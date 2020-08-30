package project.com.services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project.com.enity.Book;
import project.com.util.Constant;

public class ShowListBook {
	
	public void showListBooks (){
		
		List<Book> listBooks = new ArrayList<>();
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(Constant.URL, Constant.USER, Constant.PASSWORD);
			System.out.println("Connect Success");
			
			Statement statement = connection.createStatement();
			ResultSet resultSetBook = statement.executeQuery("SELECT * FROM Book");
			
			while (resultSetBook.next()) {
				Book book = new Book();
				book.setId(resultSetBook.getInt(1));
				book.setBookName(resultSetBook.getString(2));
				book.setBookTitle(resultSetBook.getString(3));
				book.setAuthor(resultSetBook.getString(4));
				book.setBrief(resultSetBook.getString(5));
				book.setPublisher(resultSetBook.getString(6));
				book.setContent(resultSetBook.getString(7));
				book.setCategory(resultSetBook.getString(8));
//				//book.display();
				listBooks.add(book);

			}
		
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connect Fail");
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		for (Book book : listBooks) {
			book.display();
		}
		
	}
}
