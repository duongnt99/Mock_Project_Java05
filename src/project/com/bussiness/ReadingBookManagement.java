package project.com.bussiness;

import java.util.Scanner;

import project.com.services.DeleteBook;
import project.com.services.DisplayBookcase;
import project.com.services.EditBook;
import project.com.services.InsertBook;
import project.com.services.Login;
import project.com.services.ReadBook;
import project.com.services.SearchBook;
import project.com.services.ShowListBook;
import project.com.util.Constant;
import project.com.util.Validate;

public class ReadingBookManagement {
	ReadingBookManagement readingBookManagement = new ReadingBookManagement();
	
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		
		ReadBook readBook = new ReadBook();
		SearchBook searchBook = new SearchBook();
		DisplayBookcase displayBookcase = new DisplayBookcase();
		InsertBook insertBook = new InsertBook();
		EditBook editBook = new EditBook();
		DeleteBook deleteBook = new DeleteBook();

		
		while (true) {
			String choiceAdmin;
			String choiceUser;
			Login login = new Login();
			login.handlingLogin();
			if(login.getUser().getState() == 1) {
				System.out.println("Hello Admin, Please select function bellow by entering the corresponding number.");
				System.out.println("MENU");
				System.out.println("=========================");
				System.out.println("1.Create Book");
				System.out.println("2.Update Content Book");
				System.out.println("3.Delete Book");
				System.out.println("4.Exit");
				System.out.println("=========================");
				System.out.println("Enter choice: ");
				
				choiceAdmin = scanner.nextLine();
				switch (choiceAdmin) {
				case Constant.CREATE_NEW_BOOK:
					insertBook.InsertBookToDB();
					break;
				case Constant.UPDATE_BOOK:
					editBook.updateBook();
					break;
				case Constant.DELETE_BOOK:
					deleteBook.deletedBook();
					break;
				case Constant.EXIT_EDIT_BOOK:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid!");
					break;
				}
				
			}
			else {
				while (true) {
					boolean logout = false;
					System.out.println("Hello User, Please select function bellow by entering the corresponding number.");
					System.out.println("=========================");
					System.out.println("1.View List Books");
					System.out.println("2.Read Book");
					System.out.println("3.Search Book");
					System.out.println("4.View Book Case");
					System.out.println("5.Edit Book Case");
					System.out.println("6.Logout");
					System.out.println("=========================");
					System.out.println("Enter choice: ");
					
					int bookcaseId = login.getUser().getId();
					choiceUser = scanner.nextLine();
					switch (choiceUser) {
					case Constant.VIEW_LIST_BOOKS:
						ShowListBook showListBook = new ShowListBook();
						showListBook.showListBooks();
						break;
					case Constant.READ_BOOK:
						System.out.println("Please enter the book's id: ");
						
						String input = scanner.nextLine();
						try {
							int idBook = Validate.checkId(input);
							System.out.println(readBook.readBook(idBook));
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case Constant.SEARCH_BOOKS:
						searchBook.searchMenu();
						break;
					case Constant.VIEW_YOUR_BOOKCASE:
						System.out.println("Your bookcase has");
						displayBookcase.displayMyBookcase(bookcaseId);
						break;
					case Constant.EDIT_YOUR_BOOKCASE:
						Scanner scan = new Scanner(System.in);
						displayBookcase.EditMyBookcase(bookcaseId, scan);
						break;
					case Constant.lOGOUT:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid!");// nos xuong day thi phai
						break;
					}
					System.out.println("*****************");
				}
			}
		}

		
	}
}
