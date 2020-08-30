package project.com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project.com.dbo.ConnectDB;
import project.com.enity.Book;
import project.com.util.Constant;
import project.com.util.Validate;

public class SearchBook {
private Connection connection;
	
	private void initConnect() throws Exception {
		try {
			connection = ConnectDB.getConnect();
		} catch (Exception e) {
			throw new Exception("Connect Failed");
		}
	}
	
	private boolean setListBook(String sql, List<Book> books) { // connect database and set list result
		boolean checksetListBook = false;
		PreparedStatement pstm = null;
		try {
			pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				Book book = new Book(rs.getInt("BookID"), rs.getString("BookName"), rs.getString("BookTitle"), rs.getString("Author"), rs.getString("Publisher"), rs.getString("Category"));
				books.add(book);
			}
			checksetListBook = true;
		} catch (SQLException e) {
			System.out.println("Query error");
		}
		finally {
			if(pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					System.out.println("Close PreparedStatement Error");
				}
			}
		}
		return checksetListBook;
	}
	
	private void display(List<Book> books) {  ///// display list result
		if(books.size() == 0) {
			System.out.println("Can't find the book");
			return;
		}
		int stt = 1;
		System.out.println("About " + books.size() + " result:");
		System.out.printf("%-5s%-5s%-25s%-25s%-25s%-25s%-25s\n","STT", "ID", "NAME", "AUTHOR", "CATEGORY", "TITLE", "PUBLISHER");
		for (Book book : books) {
			System.out.printf("%-5s%-5s%-25s%-25s%-25s%-25s%-25s\n", stt++, book.getId(), book.getBookName(), book.getAuthor(), book.getCategory(), book.getBookTitle(), book.getPublisher());
		}
		System.out.println("---------------------------------");
	}
	
	private String getSql(String searchStr, String typeSearch ) {  // return string sql
		String resultStr = "Select b.BookID, b.BookName, b.Author, b.Category, b.BookTitle, b.Publisher from Book b " + 
				"where b." + typeSearch + " = N'" + searchStr.trim() + "'";
		return resultStr;
	}
	
	private void searchByName(Scanner scanner) { // search by name book
		List<Book> books = new ArrayList<Book>();
		String sql = "";
		String searchStr = "";
		while (true) {
			System.out.print("Please enter book's name: ");
			searchStr = scanner.nextLine();
			if(!Validate.chekSearchStr(searchStr)) {
				System.out.println("Name invalid");
				continue;
			}
			break;
		}
		sql = getSql(searchStr, "BookName");
		if(setListBook(sql, books)) //// if get list book, display
			display(books);
	}
	
	private void searchByAuthor(Scanner scanner) { // search by author
		List<Book> books = new ArrayList<Book>();
		String sql = "";
		String searchStr = "";
		while (true) {
			System.out.print("Please enter book's Author: ");
			searchStr = scanner.nextLine();
			if(!Validate.chekSearchStr(searchStr)) {
				System.out.println("Author invalid");
				continue;
			}
			break;
		}
		sql = getSql(searchStr, "Author");
		if(setListBook(sql, books))  //// if get list book, display
			display(books);
	}	
	
	
	private void searchByCategory(Scanner scanner) { //// search by category
		List<Book> books = new ArrayList<Book>();
		String sql = "";
		String searchStr = "";
		while (true) {
			System.out.print("Please enter book's Category: ");
			searchStr = scanner.nextLine();
			if(!Validate.chekSearchStr(searchStr)) {
				System.out.println("Category invalid");
				continue;
			}
			break;
		}
		sql= getSql(searchStr, "Category");
		if(setListBook(sql, books))  //// if get list book, display
			display(books);
	}
	
	public void searchMenu() { ///// Search menu includes option searchs
		try {
			initConnect(); // connect database
			Scanner scanner = new Scanner(System.in);
			String option = "";
			boolean checkExit = true; // check exit condition 
			while (checkExit) {
				System.out.println("-------------Search Menu---------------");
				System.out.println("Please select search type:");
				System.out.println("1: By name");
				System.out.println("2: By author");
				System.out.println("3: By category");
				System.out.println("4: Exit");		
				option = scanner.nextLine();
				if(!Validate.checkSearch(option)) {
					System.out.println("Input invalid");
					continue;
				}		
				switch (option) {
					case Constant.BY_NAME:
						searchByName(scanner);
						break;
					case Constant.BY_AUTHOR:
						searchByAuthor(scanner);
						break;
					case Constant.BY_CATEGORY:
						searchByCategory(scanner);
						break;
					case Constant.EXIT_SEARCH:
						checkExit = false;
						break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
