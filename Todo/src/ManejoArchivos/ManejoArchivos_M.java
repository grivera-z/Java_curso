package ManejoArchivos;

public class ManejoArchivos_M {
    private static final String NOMBRE_ARCHIVO = "C:\\Users\\Gabri\\Documents\\pruebaJava.txt";
    public static void main(String[] args) {
        //Crear Archivo
        Archivos.crearArchivo(NOMBRE_ARCHIVO);
        //Escribir a un archivo
        Archivos.escribirArchivo(NOMBRE_ARCHIVO);
        //Leer de un archivo
        Archivos.leerArchivo(NOMBRE_ARCHIVO);
        //Anexar Informacion
        Archivos.anexarArchivo(NOMBRE_ARCHIVO);
        //Leer archivo
        Archivos.leerArchivo(NOMBRE_ARCHIVO);
    }
}
