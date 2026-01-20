package com.dbinterface.database;

import java.sql.*;
import java.nio.file.*;
import java.io.IOException;

public class createDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/Pharmacy";
    private static final String USER = "admin";
    private static final String PASSWORD = "Rootroot1!";

    public static void createDatabaseFromSQL(String sqlFilePath)
            throws SQLException, IOException {

        // Read SQL file
        String sql = Files.readString(Paths.get(sqlFilePath));

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            try{
                Statement databaseTest = conn.createStatement();
                databaseTest.execute("USE Pharmacy;");

            } catch(SQLException e){
                stmt.execute(sql);
                System.out.println("Database created successfully.");
            }

        }
    }
}
