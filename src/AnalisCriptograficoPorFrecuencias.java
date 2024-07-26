/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase AnalisisCriptograficoPorFrecuencias - Se busca las letras con mas frecuencias de uso en el lenguaje al ser encon-
 trada alguna de estas se usa la clave de encriptación para desencriptar el archivo y validar el texto buscando palabras
 comunes del idioma, buscando reducir el número de intentos.
 Autor - Mario García. mariogarcia1040@gmail.com
 19-Mayo-2024 | 25-Julio-2024
*/

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class AnalisCriptograficoPorFrecuencias {

    DesplazarCaracter desplazarCaracter = new DesplazarCaracter();
    PalabrasComunesEnEspanol palabrasComunesEnEspanol = new PalabrasComunesEnEspanol();

    private static HashMap<Character, Integer> obtenerCharYNumeroParaHashMap(String textoAAnalizar) {
        HashMap<Character, Integer> numeroDeCaracteresEncontrados = new HashMap<>();
        for (int i = 0; i < textoAAnalizar.length(); i++) {
            char caracterAAnalizar = textoAAnalizar.charAt(i);
            if (!numeroDeCaracteresEncontrados.containsKey(caracterAAnalizar)) {
                numeroDeCaracteresEncontrados.put(caracterAAnalizar, 1);
            } else {
                numeroDeCaracteresEncontrados.put(caracterAAnalizar, numeroDeCaracteresEncontrados.get(caracterAAnalizar) + 1);
            }
        }
        return numeroDeCaracteresEncontrados;
    }

    String caracterQueMasApareceEnTexto(String textoAAnalizar) {
        var numeroDeCaracteresEncontrados = obtenerCharYNumeroParaHashMap(textoAAnalizar);
        int mayorNumeroDeApariciones = 0;
        char caracterMasComun = 0;
        for (Map.Entry<Character, Integer> entry : numeroDeCaracteresEncontrados.entrySet()) {
            if (entry.getValue() > mayorNumeroDeApariciones) {
                mayorNumeroDeApariciones = entry.getValue();
                caracterMasComun = entry.getKey();
            }
        }
        JOptionPane.showMessageDialog(null, "Caracter más común en el texto: \"" + caracterMasComun
                + "\" \nAparece: " + mayorNumeroDeApariciones + " veces","Frecuencia de aparición", JOptionPane.INFORMATION_MESSAGE);
        return desencriptarConClaveDeCaracterComun(caracterMasComun, textoAAnalizar);
    }

    String desencriptarConClaveDeCaracterComun(char caracterMasComun, String cadenaEncriptada) {
        char[] caracteresComunesEnElIdioma = {' ', 'a', 'e', 'o', 's', 'r', 'n', 'i', 'l', 'd', 'u', 't'};
        String resultado = "No se encontraron coincidencias";
        for (char c : caracteresComunesEnElIdioma) {
            int valorDeClaveObtenida = c - caracterMasComun;
            JOptionPane.showMessageDialog(null, "Caracter común en idioma: \"" + c + "\" caracter" +
                    " con mas apariciones en texto: \"" + caracterMasComun + "\" \nClave encontrada: " + valorDeClaveObtenida);
            resultado = desplazarCaracter.desplazarCaracterDeLaCadena(cadenaEncriptada, valorDeClaveObtenida);
            if (palabrasComunesEnEspanol.buscarPalabrasComunes(resultado)) {
                JOptionPane.showMessageDialog(null, "Se encontraron coincidencias, posible texto desencriptado");
                return resultado;
            }
        }
        return resultado;
    }

}