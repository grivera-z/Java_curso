package ProyectoFinal;

import ProyectoFinal.peliculas.negocio.CatalogoPeliculas;
import ProyectoFinal.peliculas.negocio.CatalogoPeliculasImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProyectoFinal_M {
    private static final String NOMBRE_ARCHIVO = "C:\\Users\\Gabri\\Documents\\peliculas.txt";
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        CatalogoPeliculasImpl cpi = new CatalogoPeliculasImpl();
        boolean salir = false;
        int opcion;
        while(!salir){
            System.out.println("1.- Iniciar Catalogo Peliculas");
            System.out.println("2.- Agregar pelicula");
            System.out.println("3.- Listar Pelicula");
            System.out.println("4.- Buscar Pelicula");
            System.out.println("5.- Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        cpi.iniciarArchivo(NOMBRE_ARCHIVO);
                        break;
                    case 2:
                        System.out.println("Nombre de la Pelicula:");
                        Scanner sn2 = new Scanner(System.in);
                        String pelicula = sn2.nextLine();
                        if(pelicula==null)
                            System.out.println();
                        else {
                            cpi.agregarPelicula(pelicula,NOMBRE_ARCHIVO);
                        }
                        break;
                    case 3:
                        cpi.listarPeliculas(NOMBRE_ARCHIVO);
                        break;
                    case 4:
                        System.out.println("Nombre de la Pelicula:");
                        Scanner sn3 = new Scanner(System.in);
                        String buscar = sn3.nextLine();
                        if(buscar==null)
                            System.out.println();
                        else {
                            cpi.buscarPelicula(NOMBRE_ARCHIVO, buscar);
                        }
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
/**
 * Elige Opcion:
 * 1.- Iniciar Catalogo Peliculas
 * 2.- Agregar pelicula
 * 3.- Listar Pelicula
 * 4.- Buscar Pelicula
 * 0.- Salir
 *
 * ej:
 * 2
 * Introduce el nombre de una pelicula a agregar:
 * Batman
 * se ha escrito correctamente al archivo
 */