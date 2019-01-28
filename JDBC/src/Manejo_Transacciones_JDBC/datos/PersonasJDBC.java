package Manejo_Transacciones_JDBC.datos;

import Manejo_Transacciones_JDBC.domain.Persona;

import java.sql.*;
import java.util.*;

public class PersonasJDBC {
    //Nos apoyamos de la llave primaria autoincrementable de MYSQL
    //por lo que se omite el campo de persona_id
    //Se utiliza un prepareStatement,por lo que podemos
    //utilizar parametros (signos de ?)
    //los cuales posteriormente sera sustituidos por el parametro respectivo
    private java.sql.Connection userConn;
    private final String SQL_INSERT = "INSERT INTO persona(nombre,apellido) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre=?,apellido=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";
    private final String SQL_SELECT = "SELECT id_persona,nombre,apellido FROM persona ORDER by id_persona";

    public PersonasJDBC(){}
    public PersonasJDBC(Connection conn){
        this.userConn = conn;
    }
    public int insert(String nombre,String apellido) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; // No se utiliza en este ejercicio
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,nombre);//param 1 => ?
            stmt.setString(index++,apellido); //param 2 => ?
            System.out.println("Ejecutamos query: "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registos afectados: "+ rows);
        }finally {
            Conexion.close(stmt);
            if(this.userConn==null){
                Conexion.close(conn);
            }
        }
        return rows;
    }
    public int update(int id_persona,String nombre,String apellido) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,nombre);//param 1 => ?
            stmt.setString(index++,apellido); //param 2 => ?
            stmt.setInt(index,id_persona);//param 3 => ?
            System.out.println("Ejecutamos query: "+SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registos Actualizados: "+ rows);
        }finally {
            Conexion.close(stmt);
            if(this.userConn==null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }
    public int delete(int id_persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,id_persona);
            System.out.println("Ejecutamos query: "+SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registos Eliminados: "+ rows);
        }finally {
            Conexion.close(stmt);
            if(this.userConn==null) {
                Conexion.close(conn);
            }
        }
        return rows;
    }
    public List<Persona> select() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
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
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn==null) {
                Conexion.close(conn);
            }
        }
        return personas;
    }
}
