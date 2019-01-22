package ProyectoFinal.peliculas.negocio;

import ProyectoFinal.peliculas.datos.AccesoDatosImpl;
import ProyectoFinal.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {
    public CatalogoPeliculasImpl(){}

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        AccesoDatosImpl a1 =  new AccesoDatosImpl();
        try {
            a1.escribir(new Pelicula(nombrePelicula), nombreArchivo, true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        AccesoDatosImpl a1 =  new AccesoDatosImpl();
        try {
            for (Object elemento:a1.listar(nombreArchivo)) {
                System.out.print(elemento + " ");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        AccesoDatosImpl a1 =  new AccesoDatosImpl();
        try {
            String Pelicula = a1.buscar(nombreArchivo,buscar);
            System.out.println("Pelicula = " + Pelicula);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        AccesoDatosImpl a1 =  new AccesoDatosImpl();
        try {
            if(!a1.existe(nombreArchivo)) {
                a1.crear(nombreArchivo);
                System.out.println("El Archivo se ha Modificado");
            }
            else
                System.out.println("El Archivo ya Existe :)");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
