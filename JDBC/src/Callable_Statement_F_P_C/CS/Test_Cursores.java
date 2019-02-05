package Callable_Statement_F_P_C.CS;
import Callable_Statement_F_P_C.CS.datos.Conexion;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.oracore.OracleType;

public class Test_Cursores {
    public static void main(String[] args) {
        //Utilizamos una clase de oracle para poder procesar el
        //Cursor que regresa la funcion de Oracle
        OracleCallableStatement oraCallStmt = null;
        OracleResultSet deptResultSet = null;
        try{
            Connection con = Conexion.getConnection();
            //Tiene dos parametros que posteriormente se definiran
            oraCallStmt = (OracleCallableStatement) con.prepareCall("{ ? = call ref_cursor_package.get_dept_ref_cursor(?)}");
            //Indicamos el tipo de regreso, el cual es un cursor
            oraCallStmt.registerOutParameter(1, OracleTypes.CURSOR);
            oraCallStmt.setInt(2,200); //Establecemos departamento_id, parametro 2
            oraCallStmt.execute();
            //Recuperamos el resutltSet y lo convertimos a un tipo Oracle
            deptResultSet = (OracleResultSet) oraCallStmt.getCursor(1);
            while(deptResultSet.next()){
                System.out.print("ID_Departamento: "+deptResultSet.getInt(1));
                System.out.print(", Nombre_Departamento: "+deptResultSet.getString(2));
                System.out.print(", Ubicacion_id: "+ deptResultSet.getString(3));
                System.out.println();
            }
            oraCallStmt.close();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
