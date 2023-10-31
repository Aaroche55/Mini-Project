package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitialiser {

    // A method to execute a given SQL file
    public static void executeSQLFile(String filePath, Connection conn) throws Exception {
        String sql = new String(Files.readAllBytes(Paths.get(filePath)));
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:quiz.db"; 
        
        try (Connection conn = DriverManager.getConnection(jdbcUrl)) {

            executeSQLFile("src/main/java/com/example/quiz/resources/database_setup.sql", conn);
            executeSQLFile("src/main/java/com/example/quiz/resources/questions_insert.sql", conn);

            System.out.println("Database setup complete!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
