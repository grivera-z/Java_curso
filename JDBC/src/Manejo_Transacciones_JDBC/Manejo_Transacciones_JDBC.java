package Manejo_Transacciones_JDBC;

import Manejo_Transacciones_JDBC.datos.PersonasJDBC;
import Manejo_Transacciones_JDBC.datos.Conexion;
import Manejo_Transacciones_JDBC.domain.Persona;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Manejo_Transacciones_JDBC {
    public static void main(String[] args) {
        PersonasJDBC personasJDBC = new PersonasJDBC();

        //Creamos un objeto conexion,se va a compartir
        //para todos los queries que ejecutemos
        Connection conn = null;
        try {
            conn = Conexion.getConnection();
            //Revisamos si la xonexion esta en modo autocommit
            //por default es autocommit == true
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            //Creamos el Objeto PersonasJDBC
            //Proporcionamos la conexion creada
            PersonasJDBC personas = new PersonasJDBC(conn);

            //Prueba del metodo insert
            //personas.insert("Luis","Perez");
            //Prueba del metodo Update
            //personas.update(4,"Hola","Perez");
            //Prueba del metodo Delete
            //personas.delete(5);
            //Prueba del Metodo Select
            List<Persona> personaslist = personas.select();
            for (Persona persona : personaslist) {
                System.out.println(persona);
            }
        }catch (SQLException sqle){
            //Hacemos rollback en caso de error
            try {
                System.out.println("Entramos al rollback");
                //Imprimimos la excepcion a la consola
                sqle.printStackTrace(System.out);
                //Hacemos rollback
                conn.rollback();
            } catch (SQLException e1) {
                System.out.println("Error en Rollback");
                e1.printStackTrace(System.out);
            }
        }
    }
}
