package project.com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import project.com.dbo.ConnectDB;

public class InsertBook {
	public static void InsertBookToDB() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1.Enter the name: ");
        String bookName = scanner.nextLine();
        System.out.print("2.Enter the author: ");
        String bookTitle = scanner.nextLine();
        System.out.print("3.Enter the category: ");
        String author = scanner.nextLine();
        System.out.print("4.Enter the brief: ");
        String brief = scanner.nextLine();
        System.out.print("5.Enter the title: ");
        String publisher = scanner.nextLine();
        System.out.print("6.Enter the publisher: ");
        String content = scanner.nextLine();
        System.out.print("7.Enter the content: ");
        String category = scanner.nextLine();

        if (bookName.equals("") || bookTitle.equals("") || author.equals("") || brief.equals("") || publisher.equals("")
                || content.equals("") || category.equals("")) {
            System.out.println("book fail created");
        } else {
            try (Connection con = ConnectDB.getConnect();
                 PreparedStatement stmt = con.prepareStatement("INSERT INTO BOOK (BookName, BookTitle, Author, Brief," +
                         " Publisher, Content, Category)  VALUES(?,?,?,?,?,?,?)");) {
                stmt.setString(1, bookName);
                stmt.setString(2, bookTitle);
                stmt.setString(3, author);
                stmt.setString(4, brief);
                stmt.setString(5, publisher);
                stmt.setString(6, content);
                stmt.setString(7, category);
                stmt.executeUpdate();
                System.out.println("Book successfully created!");
            }
            // Handle any errors that may have occurred.
            catch (SQLException e) {
                System.out.println("Book failed created");
            }
        }

    }
}
