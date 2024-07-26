import javax.swing.*;

/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase DesencriptadorPorFuerzaBruta - Desencripta por fuerza bruta comparando palabras contenida en cada resultado hasta
 encontrar coincidencias.
 Autor - Mario García. mariogarcia1040@gmail.com
 27-Abril-2024 | 25-Julio-2024
*/
public class DesencriptadorPorFuerzaBruta {

    DesplazarCaracter desplazarCaracter = new DesplazarCaracter();
    PalabrasComunesEnEspanol palabrasComunesEnEspanol = new PalabrasComunesEnEspanol();

    String desencriptadoPorFuerzaBruta(String cadenaEncriptada, int numeroDeIntentos) {

        String resultado = "";
        String mensaje = "";

        for (int i = 1; i < numeroDeIntentos + 1; i++) {
            mensaje = "Intentos: " + i;
            resultado = desplazarCaracter.desplazarCaracterDeLaCadena(cadenaEncriptada, -i); // El valor es negativo para desencriptar
            if (palabrasComunesEnEspanol.buscarPalabrasComunes(resultado)) {
                JOptionPane.showMessageDialog(null, mensaje + "\nPosible texto encontrado",
                        "Desencriptado exitoso", JOptionPane.INFORMATION_MESSAGE);
                return resultado;
            }
        }
        JOptionPane.showMessageDialog(null, mensaje + "\nNo se encontraron coincidencias",
                "Desencriptado fallido", JOptionPane.INFORMATION_MESSAGE);
        return resultado;
    }

}