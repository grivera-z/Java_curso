package ManejoArchivos;
import java.io.*;
public class Archivos {
    public static void crearArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("El archivo se ha creado Correctamente\n");

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void escribirArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            String contenido = "Contenido a escribir en el archivo";
            salida.println(contenido);
            salida.println();
            salida.println("Fin de Escritura");
            salida.close();
            System.out.println("Se ha escrito correctamente al archivo\n");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void leerArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null){
                System.out.println("Lectura = " + lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void anexarArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
            String contenido = "Anexando informacion al archivo";
            salida.println(contenido);
            salida.println();
            salida.println("Fin de Anexar");
            salida.close();
            System.out.println("Se ha anexado la informacion Correctamente");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
