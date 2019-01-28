package Manejo_Capa_De_Datos_DTO.Personas.jdbc;

import Manejo_Capa_De_Datos_DTO.Personas.jdbc.Conexion;
import Manejo_Capa_De_Datos_DTO.Personas.dto.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase implementa la clase PersonaDao es una implementacion con la
 * tecnologia JDBC podría haber otro tipo de implementaciones con tecnologias
 * como Hibernate, iBatis, SpringJDBC, etc.
 *
 * @author Ubaldo
 *
 */

public class PersonasDaoJDBC implements PersonaDao {
    //Nos apoyamos de la llave primaria autoincrementable de MYSQL
    //por lo que se omite el campo de persona_id
    //Se utiliza un prepareStatement,por lo que podemos
    //utilizar parametros (signos de ?)
    //los cuales posteriormente sera sustituidos por el parametro respectivo
    private Connection userConn;
    private final String SQL_INSERT = "INSERT INTO persona(nombre,apellido) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre=?,apellido=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";
    private final String SQL_SELECT = "SELECT id_persona,nombre,apellido FROM persona ORDER by id_persona";

    public PersonasDaoJDBC(){}
    public PersonasDaoJDBC(Connection conn){
        this.userConn = conn;
    }

    public int insert(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; // No se utiliza en este ejercicio
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,persona.getNombre());//param 1 => ?
            stmt.setString(index++,persona.getApellido()); //param 2 => ?
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
    public int update(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,persona.getNombre());//param 1 => ?
            stmt.setString(index++,persona.getApellido()); //param 2 => ?
            stmt.setInt(index,persona.getId_persona());//param 3 => ?
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
    public int delete(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getId_persona());
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
    public List<PersonaDTO> select() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO personaDTO = null;
        List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id_persona =  rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                personaDTO = new PersonaDTO();
                personaDTO.setId_persona(id_persona);
                personaDTO.setNombre(nombre);
                personaDTO.setApellido(apellido);
                personas.add(personaDTO);
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
