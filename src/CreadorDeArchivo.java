import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase CreadorDeArchivo - Maneja el archivo llamado "encriptado.txt" y agrega la cadena de datos encriptados de otro archivo
 Autor - Mario García. mariogarcia1040@gmail.com
 25-Abril-2024 | 25-Julio-2024
*/
public class CreadorDeArchivo {

    boolean crearArchivo(Path rutaYNombreDelArchivo) {
        //Path rutaYNombreDelArchivo = FileSystems.getDefault().getPath("resultado.txt");
        if (!verificarSiExisteArchivo(String.valueOf(rutaYNombreDelArchivo))) {
            try {
                Files.createFile(rutaYNombreDelArchivo);
                JOptionPane.showMessageDialog(null, "Archivo creado con éxito " + rutaYNombreDelArchivo);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el archivo encriptado "
                        + e.getMessage() + "\n Saliendo del programa...");
                System.exit(1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un archivo con ese nombre, será borrado y creado nuevamente");
            borrarArchivo(String.valueOf(rutaYNombreDelArchivo));
        }
        return true;
    }

    private boolean verificarSiExisteArchivo(String rutaDelArchivo) {
        File existeArchivo = new File(rutaDelArchivo);
        return existeArchivo.exists();
    }

    void borrarArchivo(String rutaDelArchivo) {
        File archivoAborrar = new File(rutaDelArchivo);
        if (archivoAborrar.delete()) {
            JOptionPane.showMessageDialog(null, "Archivo duplicado fue eliminado");
            crearArchivo(Path.of(rutaDelArchivo));
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el archivo duplicado" +
                    "\nSaliendo del programa...");
            System.exit(0);
        }
    }

    void escribirCadenaEncriptada(String cadenaAescribir, Path rutaYNombreDelArchivo) {
        //Path rutaYNombreDelArchivo = FileSystems.getDefault().getPath("resultado.txt");
        try {
            Files.writeString(rutaYNombreDelArchivo, cadenaAescribir, StandardOpenOption.APPEND);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo " + e.getMessage());
        }
    }

}