package com.dbinterface;

import com.dbinterface.database.Database;
import com.dbinterface.dbUtils.Delete;
import com.dbinterface.dbUtils.Select;
import com.dbinterface.entities.*;

import java.sql.Connection;
import java.sql.SQLException;
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
            List<Employee> list = Select.selectEmployee(null, null, null, null, null);
            for (Employee e : list){
                System.out.println(e.toString());
            }
            Delete.delete("Employee", List.of("Phone = '07123467' "));
            list = Select.selectEmployee(null, null, null, null, null);
            for (Employee e : list){
                System.out.println(e.toString());
            }

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