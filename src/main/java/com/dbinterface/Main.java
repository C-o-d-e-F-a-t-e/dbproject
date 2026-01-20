package com.dbinterface;

import com.dbinterface.database.Database;
import com.dbinterface.DBUtils.Insert;
import com.dbinterface.DBUtils.Select;
import com.dbinterface.DBUtils.Delete;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            connection = Database.getConnection();
            System.out.println("Connected to MySQL database!");
            
            Select.select("Employee", null, null);
            List<String> conditions = new ArrayList<>();
            conditions.add("Phone like '0712346'");
            Delete.delete("Employee", conditions);
            Select.select("Employee", null, null);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Operation failed!" + e.getMessage());
        } finally {
            Database.closeConnection();
        }
    }
}