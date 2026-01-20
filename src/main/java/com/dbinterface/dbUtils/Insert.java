package com.dbinterface.dbUtils;

import com.dbinterface.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static boolean insert(String table, Object... values) throws SQLException {
        Connection connection = null;
        ResultSet rs = null;
        
        try {
            connection = Database.getConnection();
            rs = Database.DataBaseMetaData(table);
            
            if (rs == null) {
                throw new SQLException("Failed to get table metadata");
            }
            
            List<String> columns = new ArrayList<>();
            
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                String columnType = rs.getString("TYPE_NAME");
                String isAutoIncrement = rs.getString("IS_AUTOINCREMENT");
                
                // Skip auto-incremented column
                if ("YES".equalsIgnoreCase(isAutoIncrement)) {
                    continue;
                }
                // skip datetime columns since they already get a value by default
                if(columnType.equalsIgnoreCase("DATETIME")){
                    continue;
                }
                
                columns.add(columnName);
            }
            
            if (columns.isEmpty()) {
                throw new IllegalArgumentException("No columns found for table: " + table);
            }
            
            if (columns.size() != values.length) {
                throw new IllegalArgumentException(
                    "Number of values (" + values.length + 
                    ") does not match number of columns (" + columns.size() + ")"
                );
            }
            
            // Build SQL query with StringBuilder
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("INSERT INTO ").append(table).append(" (");
            
            // Add column names
            for (int i = 0; i < columns.size(); i++) {
                sqlBuilder.append(columns.get(i));
                if (i < columns.size() - 1) {
                    sqlBuilder.append(", ");
                }
            }
            
            sqlBuilder.append(") VALUES (");
            
            // Add placeholders
            for (int i = 0; i < columns.size(); i++) {
                sqlBuilder.append("?");
                if (i < columns.size() - 1) {
                    sqlBuilder.append(", ");
                }
            }
            
            sqlBuilder.append(")");
            
            String sql = sqlBuilder.toString();
            System.out.println("Executing SQL: " + sql);
            
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                for (int i = 0; i < values.length; i++) {
                    stmt.setObject(i + 1, values[i]);
                }
                int rowsAffected = stmt.executeUpdate();

                // commit only if there was a change
                if(rowsAffected > 0){
                    connection.commit();
                }else{
                    connection.rollback();
                }

                return rowsAffected > 0;
            }catch(SQLException e){
                System.err.println("statement execution failed" + e.getMessage());
                throw e;
            }
            
        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Insert failed: " + e.getMessage());
            throw e;
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}