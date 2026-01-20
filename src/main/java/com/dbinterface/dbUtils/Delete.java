package com.dbinterface.dbUtils;

import com.dbinterface.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Delete {
    public static boolean delete(String table, List<String> conditions) {
        Connection connection = null;
        
        try {
            connection = Database.getConnection();
            
            StringBuilder sb = new StringBuilder();
            sb.append("Delete from ").append(table);
            if(conditions != null){
                sb.append(" WHERE ");
                for (int i = 0; i < conditions.size(); i ++) {
                    sb.append(conditions.get(i));
                    if( i < conditions.size() - 1){
                        sb.append("and ");
                    }
                }
            }
            sb.append(";");
            String sql = sb.toString();

            try (PreparedStatement stmt = connection.prepareStatement(sql)) 
            {
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
                return false;
            }

        }catch(SQLException e){
            System.err.println("Select Failed :" + e.getMessage());
            return false;
        }
    }
}