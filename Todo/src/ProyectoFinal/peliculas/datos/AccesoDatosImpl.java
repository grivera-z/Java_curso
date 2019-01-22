package ProyectoFinal.peliculas.datos;

import ManejoExcepciones_2.excepciones.AccesoDatosEx;
import ManejoExcepciones_2.excepciones.EscrituraDatosEx;
import ManejoExcepciones_2.excepciones.LecturaDatosEx;
import ProyectoFinal.peliculas.domain.Pelicula;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements AccesoDatos {
    public boolean existe(String nombreArchivo){
        File tmpDir = new File(nombreArchivo);
        boolean exists = tmpDir.exists();
        return exists;
    }
    public List<Pelicula> listar(String nombreArchivo) throws AccesoDatosEx {
        List<Pelicula> peliculaList =  new ArrayList();
        try {
            if(!existe(nombreArchivo))
                throw new LecturaDatosEx("No Existe Archivo");
            File archivo = new File(nombreArchivo);
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            if (lectura == null)
                throw new LecturaDatosEx("Lista esta Vacia");
            while (lectura != null) {
                peliculaList.add(new Pelicula(String.valueOf(lectura)));
                lectura = entrada.readLine();
            }
            entrada.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return peliculaList;
    }
    public void escribir(Pelicula pelicula,String nombreArchivo,boolean anexar) throws AccesoDatosEx{

        File archivo = new File(nombreArchivo);
        try {
            if(!existe(nombreArchivo))
                throw new EscrituraDatosEx("No Existe Archivo");
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar));
            String contenido = pelicula.getNombre();
            salida.println(contenido);
            salida.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public String buscar(String nombreArchivo,String buscar){
        String found=null;
        try{
            File archivo = new File(nombreArchivo);
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while (lectura != null) {
                if(lectura.indexOf(buscar)!=-1)
                    found=lectura;
                lectura = entrada.readLine();
            }
            entrada.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        if(found==null)
            return null;
        else
            return found;
    }
    public void crear(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void borrar(String nombreArchivo){
        File fichero = new File(nombreArchivo);
        if (fichero.delete())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
            System.out.println("El fichero no puede ser borrado");
    }
}
