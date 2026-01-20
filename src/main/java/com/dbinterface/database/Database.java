package com.dbinterface.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/Pharmacy";
    private static final String USER = "admin";
    private static final String PASSWORD = "Rootroot1!";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            }
            return connection;
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            throw e;
        }
    }
    
    public static ResultSet DataBaseMetaData(String tableName) throws SQLException {
        Connection conn = getConnection();
        try {
            return conn.getMetaData().getColumns(null, null, tableName, null);
        } catch (SQLException e) {
            System.err.println("Failed to get metadata for table: " + tableName);
            throw e;
        }
    }
    
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}