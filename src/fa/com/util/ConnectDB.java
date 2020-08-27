package fa.com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-NG9M29U:1433;databaseName=testDB;integratedSecurity=true;";	
			connection = DriverManager.getConnection(connectionURL, "sa", "123456");
			System.out.println("Connect Success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Fail");
		}
	}
}
