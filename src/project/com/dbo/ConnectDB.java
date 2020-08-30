package project.com.dbo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project.com.bussiness.ReadingBookManagement;
import project.com.enity.Book;
import project.com.services.ShowListBook;
import project.com.util.Constant;

public class ConnectDB {
	private static final String connectionURL = "jdbc:sqlserver://DESKTOP-NG9M29U:1433;databaseName=testDB;integratedSecurity=true;";
	public static Connection getConnect() throws Exception {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionURL);
		} catch (Exception e) {
			throw new Exception("Connect Failed");
		}
		return connection;
	}
}
