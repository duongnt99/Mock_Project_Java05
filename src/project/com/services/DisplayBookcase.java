package project.com.services;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import project.com.enity.Book;
public class DisplayBookcase {
	public void displayMyBookcase(int bookcaseId) throws Exception {
		// Show a Bookcase
			BookcaseService bookcaseService = new BookcaseService();
			List<Book> books = bookcaseService.getBooks(bookcaseId);
			int numOfBooks = books.size();

			if (numOfBooks == 0) {
				System.out.println("Your BookCase is empty!");
			} else {
				// Show list of books in book case
				System.out.println("Your BookCase has "+ numOfBooks + " books:");
				System.out.println("STT\t id\t Title\t Author\t Category\t Publisher");
				for (int i = 1; i <= numOfBooks; i++) {
					Book book = books.get(i-1);
					System.out.println(i + "\t " + book.getId() + "\t " + book.getBookTitle() + "\t " + book.getAuthor()
							+ "\t " + book.getCategory() + "\t " + book.getPublisher());
				}
			}
			
			// Action for bookcase
	
	}
	
	public void EditMyBookcase(int bookcaseId, Scanner scan) throws Exception {
		// Show a Bookcase
		BookcaseService bookcaseService = new BookcaseService();
		int opt = 0;
		do {
			List<Book> books = bookcaseService.getBooks(bookcaseId);
			int numOfBooks = books.size();

			if (numOfBooks == 0) {
				System.out.println("Your BookCase is empty!");
			} else {
				// Show list of books in book case
				System.out.println("STT\t id\t Title\t Author\t Category\t Publisher");
				for (int i = 1; i <= numOfBooks; i++) {
					Book book = books.get(i-1);
					System.out.println(i + "\t " + book.getId() + "\t " + book.getBookTitle() + "\t " + book.getAuthor()
							+ "\t " + book.getCategory() + "\t " + book.getPublisher());
				}
			}
			
			// Action for bookcase
			System.out.println("- Please enter the number: ");
			System.out.println("1. Edit bookcase");
			System.out.println("2. Close Bookcase");

			try {
				opt = scan.nextInt();

				if (opt == 1) {
					System.out.println("- Please enter the number: ");
					System.out.println("1. Add a new book");
					System.out.println("2. Remove a book");
					System.out.println("3. Clear Bookcase");

					int subOpt = 0;
					try {
						subOpt = scan.nextInt();
						if (subOpt == 1) {
							// Add a new Book
							System.out.println("Please enter book's id: ");
							int bookId = scan.nextInt();
							bookcaseService.addBook(bookcaseId, bookId);
							System.out.println("Add new book to bookcase successfully!");
						} else if (subOpt == 2) {
							// Remove a book
							System.out.println("Please enter book's id: ");
							int bookId = scan.nextInt();
							
							bookcaseService.removeBook(bookcaseId, bookId);
							System.out.println("Remove a book from bookcase successfully!");
						} else if (subOpt == 3) {
							// Clear Bookcase
							bookcaseService.clearBookcase(bookcaseId);
							System.out.println("Clear bookcase successfully!");
						} else {
							System.out.println("Invalid number!");
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid format!");
					}

				} else if (opt == 2) {
					// break
				} else {
					System.out.println("Invalid number!");
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid format!");
			}
		} while (opt != 2);

	}
}
