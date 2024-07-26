import javax.swing.*;

/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase Desplazar caracter - Reemplaza caracteres dependiendo del número capturado llamado clave.
 Autor - Mario García. mariogarcia1040@gmail.com
 24-Abril-2024 | 19-Mayo-2024
*/
public class DesplazarCaracter {

    public char desplazarCaracter(char caracter, int clave) {
        int caracterDesplazado = caracter + clave;
        return (char) caracterDesplazado;
    }

    String desplazarCaracterDeLaCadena(String cadenaSinCaracteresDesplazados, int clave) {
        if (clave == 0) {
            //System.out.println("La clave con valor 0 no altera los datos originales");
            JOptionPane.showMessageDialog(null, "La clave con valor 0 no altera los datos originales");
            return cadenaSinCaracteresDesplazados;
        }
        StringBuilder cadenaConCaracteresDesplazados = new StringBuilder();
        for (int i = 0; i < cadenaSinCaracteresDesplazados.length(); i++) {
            char caracterSinProcesar = cadenaSinCaracteresDesplazados.charAt(i);
            char caracterProcesado = desplazarCaracter(caracterSinProcesar, clave);
            cadenaConCaracteresDesplazados.append(caracterProcesado);
        }
        return cadenaConCaracteresDesplazados.toString();
    }

}