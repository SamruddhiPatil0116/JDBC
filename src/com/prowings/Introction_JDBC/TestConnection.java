package com.prowings.Introction_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hibernate_db";
        String user = "root";
        String password = "Samu@9929";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection Successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
