package com.prowings.Introction_JDBC;


	
	

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	public class Jdbc_Update {

		public static void main(String[] args) {

			System.out.println("main started!!");
			Connection connection = null;
			try {
				// step-1 - Register the driver class. (Note-In latest JDK versions, this step
				// is optional)
				Class.forName("com.mysql.cj.jdbc.Driver");
				// step-2 - Create connection object
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/samrudhipatil",
						"root", "Samu@9929");
				// step-3 - create Statement/PreparedStatement object
				Statement statement = connection.createStatement();
				// step-4 - Execute the query
				//String UpdateQuery = "Update  student SET address = 'Mumbai' WHERE id = 2;";
                  String UpdateQuery = "Update student SET name = 'Ram Patil'WHERE id = 6;";
				int res = statement.executeUpdate(UpdateQuery);
				
				System.out.println(">>>> Update query result : "+res);
				
			} catch (ClassNotFoundException e) {
				System.out.println("Some error occurred during connecting to DB!!" + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Some error occurred during connecting to DB!!" + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Some error occurred!!" + e.getMessage());
			}
			finally {
				
				//step-5 - Close the connection
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			
			System.out.println("main ended!!");
		}

	}

