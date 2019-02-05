package Manejo_Metadatos_JDBC;
import Manejo_Metadatos_JDBC.datos.Conexion;
import java.sql.*;
import oracle.jdbc.OracleResultSetMetaData;

public class TestMetadatos {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employees");
            //Obtenemos un objeto de metadatos de Oracle
            OracleResultSetMetaData rsOracle = (OracleResultSetMetaData) rs.getMetaData();
            if(rsOracle == null){
                System.out.println("Metadato no disponibles");
            }else{
                //Preguntamos cuantas columnas tiene tabla de empleados
                int columnCount = rsOracle.getColumnCount();
                //Desplegamos el Numero de columans
                System.out.println("columnCount = " + columnCount);
                for (int i = 1; i < columnCount ; i++) {
                    //Desplegamos el nombre de la columna
                    System.out.print("Nombre Columna: "+ rsOracle.getColumnName(i));
                    //Desplegamos el tipo de la columan
                    System.out.print("  , Tipo Columna: " + rsOracle.getColumnTypeName(i));
                    //Desplegamos si la columna puede almacenar valores nulos
                    switch (rsOracle.isNullable(i)){
                        case OracleResultSetMetaData.columnNoNulls:
                            System.out.print(", No acepta Nulos");
                            break;
                        case OracleResultSetMetaData.columnNullable:
                            System.out.print(", Si acepta Nulos");
                            break;
                        case OracleResultSetMetaData.columnNullableUnknown:
                            System.out.print(", Valor Nulo Desconocido");
                            break;
                    }
                    System.out.println();
                }
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            Conexion.close(rs);
            Conexion.close(con);
        }

    }
}
