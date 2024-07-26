import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 Proyecto - Analizador criptografico
 Programa que encripta y desencripta archivo de texto plano usando método césar
 Clase LectorDeArchivo - Lee un archivo de texto regresandolo como cadena.
 Autor - Mario García. mariogarcia1040@gmail.com
 24-Abril-2024 | 27-Mayo-2024
*/
public class LectorDeArchivo {
    String leerArchivo(String archivoAleer) {
        Path rutaArchivo = FileSystems.getDefault().getPath(archivoAleer);
        String contenidoDelArchivo = null;
        try {
            contenidoDelArchivo = Files.readString(rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error en proceso de lectura de archivo " + e.getMessage());
            System.out.println("Fin del programa");
            System.exit(1);
        }
        return contenidoDelArchivo;
    }
}