package Manejo_Capa_De_Datos_DTO.Usuarios.jdbc;

import Manejo_Capa_De_Datos_DTO.Usuarios.jdbc.Conexion;
import Manejo_Capa_De_Datos_DTO.Usuarios.dto.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC implements UsuarioDao {
    //Nos apoyamos de la llave primaria autoincrementable de MYSQL
    //por lo que se omite el campo de persona_id
    //Se utiliza un prepareStatement,por lo que podemos
    //utilizar parametros (signos de ?)
    //los cuales posteriormente sera sustituidos por el parametro respectivo
    private Connection userConn;
    private final String SQL_INSERT = "INSERT INTO usuario(usuario,password) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE usuario SET usuario=?,password=? WHERE id_usuario=?";
    private final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";
    private final String SQL_SELECT = "SELECT id_usuario,usuario,password FROM usuario ORDER by id_usuario";

    public UsuarioDaoJDBC(){}
    public UsuarioDaoJDBC(Connection conn){
        this.userConn = conn;
    }

    public int insert(UsuarioDTO usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; // No se utiliza en este ejercicio
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Manejo_Capa_De_Datos_DTO.Personas.jdbc.Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,usuario.getUsuario());//param 1 => ?
            stmt.setString(index++,usuario.getPassword()); //param 2 => ?
            System.out.println("Ejecutamos query: "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registos afectados: "+ rows);
        }finally {
            Manejo_Capa_De_Datos_DTO.Personas.jdbc.Conexion.close(stmt);
            if(this.userConn==null){
                Conexion.close(conn);
            }
        }
        return rows;
    }
    public int update(UsuarioDTO usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,usuario.getUsuario());//param 1 => ?
            stmt.setString(index++,usuario.getPassword()); //param 2 => ?
            stmt.setInt(index,usuario.getId_usuario());//param 3 => ?
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
    public int delete(UsuarioDTO usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,usuario.getId_usuario());
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
    public List<UsuarioDTO> select() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO usuarioDTO = null;
        List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
        try {
            conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id_persona =  rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId_usuario(id_persona);
                usuarioDTO.setUsuario(nombre);
                usuarioDTO.setPassword(apellido);
                usuarios.add(usuarioDTO);
            }
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn==null) {
                Conexion.close(conn);
            }
        }
        return usuarios;
    }

}
