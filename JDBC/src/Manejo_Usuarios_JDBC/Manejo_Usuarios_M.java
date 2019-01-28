package Manejo_Usuarios_JDBC;
import java.util.*;
import Manejo_Usuarios_JDBC.datos.UsuariosJDBC;
import Manejo_Usuarios_JDBC.domain.Usuario;

public class Manejo_Usuarios_M {
    public static void main(String[] args) {
        UsuariosJDBC ujdbc = new UsuariosJDBC();
        //Prueba del metodo insert
            ujdbc.insert("Strechi","juxy");
        //Prueba del metodo Update
            //ujdbc.update(2,"Strechi","juxy");
        //Prueba del metodo Delete
            //ujdbc.delete(3);




        List<Usuario> usuarios = ujdbc.select();
        for (Usuario usuario:usuarios) {
            System.out.println(usuario);
        }

    }
}
