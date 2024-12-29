package com.prowings.Introction_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/samrudhipatil";
        String user = "root";
        String password = "Samu@9929";

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM STUDENT";
            //stmt.executeUpdate(query);
            System.out.println("Data inserted successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
