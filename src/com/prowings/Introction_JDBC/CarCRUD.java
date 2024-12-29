package com.prowings.Introction_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CarCRUD {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/samrudhipatil";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Samu@9929";
	
	public static void main(String[] args) {
		
		 try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	             Scanner scanner = new Scanner(System.in)) {

	            System.out.println("Connected to the database!");
	            boolean exit = false;

	            while (!exit) {
	                System.out.println("\nCar CRUD Operations:");
	                System.out.println("1. Create Car");
	                System.out.println("2. Read Cars");
	                System.out.println("3. Update Car");
	                System.out.println("4. Delete Car");
	                System.out.println("5. Exit");
	                System.out.print("Choose an option: ");
	                int choice = scanner.nextInt();

	                switch (choice) {
	                    case 1:
	                        createCar(connection, scanner);
	                        break;
	                    case 2:
	                        readCars(connection);
	                        break;
	                    case 3:
	                        updateCar(connection, scanner);
	                        break;
	                    case 4:
	                        deleteCar(connection, scanner);
	                        break;
	                    case 5:
	                        exit = true;
	                        System.out.println("Exiting the application. Goodbye");
	                        break;
	                    default:
	                        System.out.println("Invalid choice! Please try again.");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void createCar(Connection connection, Scanner scanner) throws SQLException {
	        System.out.print("Enter make: ");
	        String make = scanner.next();
	        System.out.print("Enter model: ");
	        String model = scanner.next();
	        System.out.print("Enter year: ");
	        int year = scanner.nextInt();

	        String sql = "INSERT INTO cars (make, model, year) VALUES (?, ?, ?)";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setString(1, make);
	            pstmt.setString(2, model);
	            pstmt.setInt(3, year);

	            int rows = pstmt.executeUpdate();
	            System.out.println(rows + " car(s) added successfully!");
	        }
	    }

	    private static void readCars(Connection connection) throws SQLException {
	        String sql = "SELECT * FROM cars";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            System.out.println("Car List:");
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id") +
	                        ", Make: " + rs.getString("make") +
	                        ", Model: " + rs.getString("model") +
	                        ", Year: " + rs.getInt("year"));
	            }
	        }
	    }

	    private static void updateCar(Connection connection, Scanner scanner) throws SQLException {
	        System.out.print("Enter car ID to update: ");
	        int id = scanner.nextInt();
	        System.out.print("Enter new make: ");
	        String make = scanner.next();
	        System.out.print("Enter new model: ");
	        String model = scanner.next();
	        System.out.print("Enter new year: ");
	        int year = scanner.nextInt();

	        String sql = "UPDATE cars SET make = ?, model = ?, year = ? WHERE id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setString(1, make);
	            pstmt.setString(2, model);
	            pstmt.setInt(3, year);
	            pstmt.setInt(4, id);

	            int rows = pstmt.executeUpdate();
	            System.out.println(rows + " car(s) updated successfully!");
	        }
	    }

	    private static void deleteCar(Connection connection, Scanner scanner) throws SQLException {
	        System.out.print("Enter car ID to delete: ");
	        int id = scanner.nextInt();

	        String sql = "DELETE FROM cars WHERE id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setInt(1, id);

	            int rows = pstmt.executeUpdate();
	            System.out.println(rows + " car(s) deleted successfully!");
	        }
		
		
	}
	
	
}


