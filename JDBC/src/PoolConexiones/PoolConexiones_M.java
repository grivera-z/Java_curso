package PoolConexiones;

import PoolConexiones.Capapdatos.Pool.PoolConexionesMysql;
import PoolConexiones.Capapdatos.Pool.PoolConexionesOracle;
import java.sql.*;

public class PoolConexiones_M {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            //Probamos el pool de MySql
            //Y Ejecutamos una consulta
            conn = PoolConexionesMysql.getConexion();
            System.out.println("Utilizamos el pool de conexiones Mysql");
            stmt = conn.prepareStatement("SELECT * FROM persona");
            rs = stmt.executeQuery();
            while (rs.next()){
                System.out.print(" "+ rs.getInt(1)); //id_Persona
                System.out.print(" "+ rs.getString(2)); //Nombre
                System.out.println(" "+ rs.getString(3)); //Apellido
            }
            conn.close();
            stmt.close();
            rs.close();
            System.out.println();
            //Probamos el Pool de Oracle
            //Y Ejecutamos una consulta
            conn = PoolConexionesOracle.getConexion();
            System.out.println(" Utilizamos el pool de conexion de Oracle ");
            stmt = conn.prepareStatement("SELECT * FROM employees WHERE employee_id in (100,101,102)");
            rs = stmt.executeQuery();
            while (rs.next()){
                System.out.print(" "+ rs.getInt(1)); //id_empleado
                System.out.print(" "+ rs.getString(2)); //Nombre
                System.out.println(" "+ rs.getString(3)); //Apellido
            }
            conn.close();
            stmt.close();
            rs.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }


    }
}
