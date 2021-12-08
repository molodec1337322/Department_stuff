package com.example.kursach2tkp.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Kursach2";
        String username = "postgres";
        String password = "admin";
        System.out.println("Connecting...");

        try {
            Class.forName("org.postgresql.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Connection successful!");
            } catch (SQLException e) {
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
