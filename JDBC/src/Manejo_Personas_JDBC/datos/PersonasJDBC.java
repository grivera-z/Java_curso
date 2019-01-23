package Manejo_Personas_JDBC.datos;
import Manejo_Personas_JDBC.domain.Persona;

import java.sql.*;
import java.util.*;
public class PersonasJDBC {
    //Nos apoyamos de la llave primaria autoincrementable de MYSQL
    //por lo que se omite el campo de persona_id
    //Se utiliza un prepareStatement,por lo que podemos
    //utilizar parametros (signos de ?)
    //los cuales posteriormente sera sustituidos por el parametro respectivo
    private final String SQL_INSERT = "INSERT INTO persona(nombre,apellido) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre=?,apellido=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";
    private final String SQL_SELECT = "SELECT id_persona,nombre,apellido FROM persona ORDER by id_persona";

    public int insert(String nombre,String apellido){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; // No se utiliza en este ejercicio
        int rows= 0;// Registors afectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,nombre);//param 1 => ?
            stmt.setString(index++,apellido); //param 2 => ?
            System.out.println("Ejecutamos query: "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registos afectados: "+ rows);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public int update(int id_persona,String nombre,String apellido){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,nombre);//param 1 => ?
            stmt.setString(index++,apellido); //param 2 => ?
            stmt.setInt(index,id_persona);//param 3 => ?
            System.out.println("Ejecutamos query: "+SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registos Actualizados: "+ rows);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public int delete(int id_persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,id_persona);
            System.out.println("Ejecutamos query: "+SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registos Eliminados: "+ rows);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    public List<Persona> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id_persona =  rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return personas;
    }
}
