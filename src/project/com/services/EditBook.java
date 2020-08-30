package project.com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import project.com.dbo.ConnectDB;
import project.com.util.Validate;

public class EditBook {
	public static void updateBook() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("please input book'id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // su ly troi lenh enter
        System.out.print("input book name: ");
        String bookName = scanner.nextLine();
        System.out.print("input book title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("input book's Author: ");
        String author = scanner.nextLine();
        System.out.print("input book brief: ");
        String brief = scanner.nextLine();
        System.out.print("input book publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("input content: ");
        String content = scanner.nextLine();
        System.out.print("input category: ");
        String category = scanner.nextLine();


        try (Connection con = ConnectDB.getConnect();
             PreparedStatement stmt = con.prepareStatement("UPDATE BOOK SET " +
                     "BookName = ?," +
                     "BookTitle = ?," +
                     "Author = ?," +
                     "Brief = ?," +
                     "Publisher = ?," +
                     "Content = ?," +
                     "Category = ? " +
                     "WHERE BookID = ? ");) {
            stmt.setString(1, bookName );
            stmt.setString(2, bookTitle );
            stmt.setString(3, author );
            stmt.setString(4, brief );
            stmt.setString(5, publisher );
            stmt.setString(6, content );
            stmt.setString(7, category );
            stmt.setInt(8, id);
            stmt.executeUpdate();
            System.out.println("Book successfully update!");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println("Update false");
        }

    }
}
