package com.dbinterface.DBUtils;

import com.dbinterface.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class Select {
    public static ResultSet select(String table, List<String> columns, List<String> conditions) throws SQLException {
        Connection connection = null;
        ResultSet rs = null;
        
        try {
            connection = Database.getConnection();
            
            StringBuilder sb = new StringBuilder();
            sb.append("Select ");
            if(columns != null)
            {    for (int i = 0; i < columns.size(); i ++) {
                    sb.append(columns.get(i));
                    if( i < columns.size() - 1){
                        sb.append(", ");
                    }
                }
            }else{
                sb.append("*");
            }
            sb.append("From ").append(table);
            if(conditions != null){
                sb.append("WHERE ");
                for (int i = 0; i < conditions.size(); i ++) {
                    sb.append(conditions.get(i));
                    if( i < conditions.size() - 1){
                        sb.append("and ");
                    }
                }
            }
            sb.append(";");
            String sql = sb.toString();
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            ResultSetMetaData meta = rs.getMetaData();

            int columnCount = meta.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(meta.getColumnName(i) + "=" + rs.getObject(i));
                    if (i < columnCount) System.out.print(" | ");
                }
                System.out.println();
            }
            return rs;

        }catch(SQLException e){
            System.err.println("Select Failed :" + e.getMessage());
            throw e;
        }
    }
}