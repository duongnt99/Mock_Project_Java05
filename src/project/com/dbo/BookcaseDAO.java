package project.com.dbo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.com.enity.Bookcase;
import project.com.enity.Book;
public class BookcaseDAO {
	public BookcaseDAO() {

	}

	public Bookcase getBookCaseById(int id) throws Exception {
		Bookcase bookcase = null;
		String sql = "SELECT * FROM BOOKCASE WHERE BookCaseName=" + id;

		try (Connection conn = ConnectDB.getConnect();) {
			if (conn != null) {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					int bookCaseId = rs.getInt("BookCaseID");
					String bookCaseName = rs.getString("BookCaseName");
					bookcase = new Bookcase(bookCaseId, bookCaseName);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bookcase;
	}

	public List<Book> getBooks(int bookcaseId) throws Exception {
		List<Book> booksList = new ArrayList<>();
		String sql = "SELECT * FROM BOOK WHERE BOOKID IN (SELECT BOOKID FROM CONTAIN WHERE BOOKCASEID="
				+ bookcaseId + ")";

		try (Connection conn = ConnectDB.getConnect();) {
			if (conn != null) {
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					int bookId = rs.getInt("BOOKID");
					String bookTitle = rs.getString("BOOKTITLE");
					String author = rs.getString("AUTHOR");
					String brief = rs.getString("BRIEF");
					String publisher = rs.getString("PUBLISHER");
					String content = rs.getString("CONTENT");
					String category = rs.getString("CATEGORY");

					Book book = new Book(bookId, bookTitle, author, brief, publisher, content, category);

					booksList.add(book);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return booksList;
	}

	public void addBook(int bookcaseId, int bookId) throws Exception {

		String sql = "INSERT INTO CONTAIN(BOOKCASEID, BOOKID) VALUES (" + bookcaseId + ", " + bookId + ")";
		try (Connection conn = ConnectDB.getConnect();) {
			if (conn != null) {
				Statement s = conn.createStatement();
				s.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void removeBook(int bookcaseId, int bookId) throws Exception {

		String sql = "DELETE FROM CONTAIN WHERE BOOKCASEID=" + bookcaseId + " AND BOOKID=" + bookId;
		try (Connection conn = ConnectDB.getConnect();) {
			if (conn != null) {
				Statement s = conn.createStatement();
				s.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void clearBookcase(int bookcaseId) throws Exception {
		String sql = "DELETE FROM CONTAIN WHERE BOOKCASEID=" + bookcaseId;
		try (Connection conn = ConnectDB.getConnect();) {
			if (conn != null) {
				Statement s = conn.createStatement();
				s.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
