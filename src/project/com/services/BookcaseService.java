package project.com.services;

import java.util.List;

import project.com.dbo.BookcaseDAO;
import project.com.enity.Book;
import project.com.enity.Bookcase;

public class BookcaseService {
	private BookcaseDAO bookcaseDao;
	
	public BookcaseService(){
		this.bookcaseDao = new BookcaseDAO();
	}
	
	public Bookcase getBookCaseById(int bookcaseId) {
		return bookcaseDao.getBookCaseById(bookcaseId);
	}
	
	public List<Book> getBooks(int bookcaseId) {
		return bookcaseDao.getBooks(bookcaseId);
	}
	
	public void addBook(int bookcaseId, int bookId) {
		bookcaseDao.addBook(bookcaseId, bookId);
	}
	
	public void removeBook(int bookcaseId, int bookId) {
		bookcaseDao.removeBook(bookcaseId, bookId);
	}
	
	public void clearBookcase(int bookcaseId) {
		bookcaseDao.clearBookcase(bookcaseId);
	}
}
