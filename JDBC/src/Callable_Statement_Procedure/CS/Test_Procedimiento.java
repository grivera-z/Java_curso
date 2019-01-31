package Callable_Statement_Procedure.CS;
import Callable_Statement_Procedure.CS.datos.Conexion;
import java.sql.*;

public class Test_Procedimiento {
    public static void main(String[] args) {
        int empleadoId = 100;
        //La fromaula que aplica el Store Procedure es
        //Salario = Salario * Incremento
        double incrementoSalario = 1.1;//Incremento del 10%
        Connection con;
        try{

            con = Conexion.getConnection();
            Statement stmt = null;
            ResultSet rset = null;
            CallableStatement cstmt = null;

            stmt = con.createStatement();

            //Obtenemos el nuevo valor del salario para el empleado seleccionado
            String query = "SELECT first_name,salary FROM employees WHERE employee_id = "+empleadoId;
            rset = stmt.executeQuery(query);
            rset.next();
            System.out.println("Nombre = " + rset.getString(1));
            System.out.println("Salario Nuevo = " + rset.getFloat(2));
            rset.close();


            //Lamamos al SP para incrementar el salario
            System.out.println("Aumento del 10% al empleado: "+ empleadoId);
            cstmt = con.prepareCall("{call set_employee_salary(?,?)}");
            cstmt.setInt(1,empleadoId);
            cstmt.setDouble(2,incrementoSalario);
            cstmt.execute();
            cstmt.close();
            //Obtenemos el nuevo valor del salario para el empleado seleccionado
            rset = stmt.executeQuery(query);
            rset.next();
            System.out.println("Nombre = " + rset.getString(1));
            System.out.println("Salario Nuevo = " + rset.getFloat(2));
            rset.close();
            stmt.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
