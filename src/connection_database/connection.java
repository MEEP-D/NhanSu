package connection_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			try {
				//con = DriverManager.getConnection("jdbc:sqlserver://DUONG-MEEP:1433;databaseName=HRMSystem;integratedSecurity=true");
				 con = DriverManager.getConnection("jdbc:sqlserver://DUONG-MEEP:1433;databaseName=HRMSystem;user=sa;password=29012020");

			} catch (SQLException e) {
				e.printStackTrace();
			}         
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}          
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
