package Manejo_Usuarios_JDBC.datos;

import Manejo_Usuarios_JDBC.domain.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuariosJDBC {
    //Nos apoyamos de la llave primaria autoincrementable de MYSQL
    //por lo que se omite el campo de persona_id
    //Se utiliza un prepareStatement,por lo que podemos
    //utilizar parametros (signos de ?)
    //los cuales posteriormente sera sustituidos por el parametro respectivo
    private final String SQL_INSERT = "INSERT INTO usuario(usuario,password) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE usuario SET usuario=?,password=? WHERE id_usuario=?";
    private final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";
    private final String SQL_SELECT = "SELECT id_usuario,usuario,password FROM usuario ORDER by id_usuario";

    public int insert(String usuario,String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; // No se utiliza en este ejercicio
        int rows= 0;// Registors afectados
        try {
            conn = Manejo_Personas_JDBC.datos.Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,usuario);//param 1 => ?
            stmt.setString(index++,password); //param 2 => ?
            System.out.println("Ejecutamos query: "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registos afectados: "+ rows);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Manejo_Personas_JDBC.datos.Conexion.close(stmt);
            Manejo_Personas_JDBC.datos.Conexion.close(conn);
        }
        return rows;
    }
    public int update(int id_usuario,String usuario,String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = Manejo_Personas_JDBC.datos.Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;  //Contador de columnas
            stmt.setString(index++,usuario);//param 1 => ?
            stmt.setString(index++,password); //param 2 => ?
            stmt.setInt(index,id_usuario);//param 3 => ?
            System.out.println("Ejecutamos query: "+SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registos Actualizados: "+ rows);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Manejo_Personas_JDBC.datos.Conexion.close(stmt);
            Manejo_Personas_JDBC.datos.Conexion.close(conn);
        }
        return rows;
    }
    public int delete(int id_usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows= 0;// Registors afectados
        try {
            conn = Manejo_Personas_JDBC.datos.Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,id_usuario);
            System.out.println("Ejecutamos query: "+SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registos Eliminados: "+ rows);
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Manejo_Personas_JDBC.datos.Conexion.close(stmt);
            Manejo_Personas_JDBC.datos.Conexion.close(conn);
        }
        return rows;
    }
    public List<Usuario> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario user = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conn = Manejo_Personas_JDBC.datos.Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id_usuario =  rs.getInt(1);
                String usuario = rs.getString(2);
                String password = rs.getString(3);
                user = new Usuario();
                user.setId_usuario(id_usuario);
                user.setUsuario(usuario);
                user.setPassword(password);
                usuarios.add(user);
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Manejo_Personas_JDBC.datos.Conexion.close(rs);
            Manejo_Personas_JDBC.datos.Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }
}
