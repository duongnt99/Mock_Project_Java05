package project.com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import project.com.dbo.ConnectDB;
import project.com.enity.User;

public class Login {
	private Connection connection;
	private User user;
	private String sql;
	
	public User getUser() {
		return user;
	}
	public void setUser() {
		user = new User();
	}
	private void init() throws Exception {
		try {
			connection = ConnectDB.getConnect();
		} catch (Exception e) {
			throw new Exception("Connect Failed");
		}
	}
	public void handlingLogin() {
		setUser();
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		System.out.println("Welcome to Read book application! Please enter your username and password.");
		try {
			init();
			while (true) {
				boolean checkError = false;
				System.out.println("Username:");
				username = scanner.nextLine();
				try {
					user.setUserName(username);
				} catch (Exception e) {
					checkError = true;
				}
				System.out.println("Password:");
				password = scanner.nextLine();
				try {
					user.setPassWord(password);
				} catch (Exception e) {
					checkError = true;
				}
				if(checkError) {
					System.out.println("Username or Password is wrong!");
					System.out.println("Please enter again:");
					continue;
				}	
				sql = "select UserID, [State] from [User] where UserName = ? and PassWord = ?";
				PreparedStatement pstm = connection.prepareStatement(sql);
				pstm.setString(1, user.getUserName());
				pstm.setString(2, user.getPassWord());
				ResultSet rs = pstm.executeQuery();
				if(rs.next()) {
					user.setId(rs.getInt(1));
					user.setState(rs.getInt(2));
					break;
				}
				else {
					System.out.println("UserName or Password is wrong!");
					System.out.println("Please enter again:");
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}
}
