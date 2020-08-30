package project.com.services;

import java.util.List;

import project.com.dbo.BookcaseDAO;
import project.com.enity.Bookcase;
import project.com.enity.Book;

public class BookcaseService {
	private BookcaseDAO bookcaseDao;
	
	public BookcaseService(){
		this.bookcaseDao = new BookcaseDAO();
	}
	
	public Bookcase getBookCaseById(int bookcaseId) throws Exception {
		return bookcaseDao.getBookCaseById(bookcaseId);
	}
	
	public List<Book> getBooks(int bookcaseId) throws Exception {
		return bookcaseDao.getBooks(bookcaseId);
	}
	
	public void addBook(int bookcaseId, int bookId) throws Exception {
		bookcaseDao.addBook(bookcaseId, bookId);
	}
	
	public void removeBook(int bookcaseId, int bookId) throws Exception {
		bookcaseDao.removeBook(bookcaseId, bookId);
	}
	
	public void clearBookcase(int bookcaseId) throws Exception {
		bookcaseDao.clearBookcase(bookcaseId);
	}
}
