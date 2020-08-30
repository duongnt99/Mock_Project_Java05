package project.com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import project.com.dbo.ConnectDB;

public class DeleteBook {
	public static void deletedBook() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input book'id: ");
        int id = scanner.nextInt();
        try (Connection con = ConnectDB.getConnect();
             PreparedStatement stmt = con.prepareStatement("DELETE FROM BOOK WHERE BookID = ?");) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Book successfully deleted!");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println("Deleted false");
        }

    }
}
