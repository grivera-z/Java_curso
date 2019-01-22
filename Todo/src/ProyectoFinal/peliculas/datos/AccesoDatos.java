package ProyectoFinal.peliculas.datos;

import ManejoExcepciones_2.excepciones.AccesoDatosEx;
import ProyectoFinal.peliculas.domain.Pelicula;

import java.util.List;

public interface AccesoDatos {
    public boolean existe(String nombreArchivo);
    public List<Pelicula> listar(String nombre) throws AccesoDatosEx;
    public void escribir(Pelicula pelicula,String nombreArchivo,boolean anexar) throws AccesoDatosEx;
    public String buscar(String nombreArchivo,String buscar);
    public void crear(String nombreArchivo);
    public void borrar(String nombreArchivo);
}