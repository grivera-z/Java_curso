package Manejo_Usuarios_JDBC.datos;
import java.sql.*;
public class UsuariosJDBC {
    //Nos apoyamos de la llave primaria autoincrementable de MYSQL
    //por lo que se omite el campo de persona_id
    //Se utiliza un prepareStatement,por lo que podemos
    //utilizar parametros (signos de ?)
    //los cuales posteriormente sera sustituidos por el parametro respectivo
    private final String SQL_INSERT = "INSERT INTO user(usuario,password) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE user SET nombre=?,apellido=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM user WHERE id_persona=?";
    private final String SQL_SELECT = "SELECT id_persona,nombre,apellido FROM user ORDER by id_persona";

}
