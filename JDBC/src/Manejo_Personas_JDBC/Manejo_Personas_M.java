package Manejo_Personas_JDBC;
import Manejo_Personas_JDBC.datos.PersonasJDBC;
import Manejo_Personas_JDBC.domain.Persona;

import java.util.*;

public class Manejo_Personas_M {
    public static void main(String[] args) {
        PersonasJDBC personasJDBC = new PersonasJDBC();
        List<Persona> personas = personasJDBC.select();
        for (Persona persona:personas) {
            System.out.println(persona);
        }
        //Prueba del metodo insert
            //personasJDBC.insert("Alberto","Perez");
        //Prueba del metodo Update
            //personasJDBC.update(5,"Hola","Perez");
        //Prueba del metodo Delete
            //personasJDBC.delete(5);
    }
}
