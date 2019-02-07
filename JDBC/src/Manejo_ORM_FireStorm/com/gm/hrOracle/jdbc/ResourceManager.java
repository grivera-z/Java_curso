package Manejo_ORM_FireStorm.com.gm.hrOracle.jdbc;

import java.sql.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceManager
{
    private static String JDBC_DRIVER ;
    private static String JDBC_URL;

    private static String JDBC_USER;
    private static String JDBC_PASSWORD;

    private static Driver driver = null;

	private static String JDBC_FILE_NAME = "jdbc";

	public static Properties loadProperties(String file){
		Properties prop = new Properties();
		ResourceBundle bundle = ResourceBundle.getBundle(file);
		Enumeration e = bundle.getKeys();
		String key = null;
		while(e.hasMoreElements()){
			key = (String) e.nextElement();
			prop.put(key,bundle.getObject(key));
		}

		JDBC_DRIVER = prop.getProperty("driver");
		JDBC_URL =  prop.getProperty("url");
		JDBC_USER = prop.getProperty("user");
		JDBC_PASSWORD = prop.getProperty("pass");
		return prop;
	}


	public static synchronized Connection getConnection()
	throws SQLException
    {
        if (driver == null)
        {
            try
            {
				//Cargamos las propiedades de conexion a la BD
				loadProperties(JDBC_FILE_NAME);
				//Se registra el driver
                Class jdbcDriverClass = Class.forName( JDBC_DRIVER );
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver( driver );
            }
            catch (Exception e)
            {
                System.out.println( "Failed to initialise JDBC driver" );
                e.printStackTrace();
            }
        }

        return DriverManager.getConnection(
                JDBC_URL,
                JDBC_USER,
                JDBC_PASSWORD
        );
    }


	public static void close(Connection conn)
	{
		try {
			if (conn != null) conn.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public static void close(PreparedStatement stmt)
	{
		try {
			if (stmt != null) stmt.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public static void close(ResultSet rs)
	{
		try {
			if (rs != null) rs.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}

	}

}
