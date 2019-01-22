package Introduccion_JDBC;
import java.sql.*;
public class Introduccion_JDBC_M {
    public static void main(String[] args) {
        //Cadena de xonexion de MySql, el parametro useSSL es opcional
        String url= "jdbc:mysql://localhost:3306/sga?useSSL=false";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Creamos el objecto de conexion
            Connection conexion = (Connection) DriverManager.getConnection(url,"root","admin");
            //Creamos un objeto Statement
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT * FROM persona";
            ResultSet result = instruccion.executeQuery(sql);
            while (result.next()){
                System.out.print("ID: " +result.getInt(1) +", ");
                System.out.print("Nombre: " + result.getString(2)+", ");
                System.out.print("Apellido: "+result.getString(3));
                System.out.println();
            }
            //Cerrar cada uno de los objetos utilizados
            result.close();
            instruccion.close();
            conexion.close();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
