package com.dbinterface.dbUtils;

import com.dbinterface.database.Database;
import com.dbinterface.entities.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {
    
    // Reusable SQL builder function
    private static PreparedStatement buildSelectStatement(Connection connection, String tableName,
                                                         List<String> columns, List<String> conditions,
                                                         String orderKey, String orientation,
                                                         String limit) throws SQLException {
        StringBuilder sqlBuilder = new StringBuilder("SELECT ");
        
        if (columns != null && !columns.isEmpty()) {
            for (int i = 0; i < columns.size(); i++) {
                sqlBuilder.append(columns.get(i));
                if (i < columns.size() - 1) sqlBuilder.append(", ");
            }
        } else {
            sqlBuilder.append("*");
        }
        
        sqlBuilder.append(" FROM ").append(tableName);
        
        if (conditions != null && !conditions.isEmpty()) {
            sqlBuilder.append(" WHERE ");
            for (int i = 0; i < conditions.size(); i++) {
                sqlBuilder.append(conditions.get(i));
                if (i < conditions.size() - 1) sqlBuilder.append(" AND ");
            }
        }
        
        if (orderKey != null && !orderKey.isEmpty()) {
            sqlBuilder.append(" ORDER BY ").append(orderKey);
            if (orientation != null && !orientation.isEmpty()) {
                sqlBuilder.append(" ").append(orientation);
            }
        }
        
        if (limit != null && !limit.isEmpty()) {
            sqlBuilder.append(" LIMIT ").append(limit);
        }
        
        sqlBuilder.append(";");
        String sql = sqlBuilder.toString();
        
        return connection.prepareStatement(sql);
    }
    
    // ========== EMPLOYEE ==========
    public static List<Employee> selectEmployee(List<String> columns, List<String> conditions, 
                                               String orderKey, String orientation, 
                                               String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Employee> employees = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "Employee", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt("EmployeeID"));
                employee.setFirstName(rs.getString("FirstName"));
                employee.setLastName(rs.getString("LastName"));
                employee.setAge(rs.getInt("Age"));
                employee.setPhone(rs.getString("Phone"));
                employee.setEmail(rs.getString("Email"));
                employee.setRole(rs.getString("Role"));
                employee.setDateOfEmployment(rs.getTimestamp("DateOfEmployment"));
                employees.add(employee);
            }
            
            return employees;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== CLIENT ==========
    public static List<Client> selectClient(List<String> columns, List<String> conditions, 
                                           String orderKey, String orientation, 
                                           String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Client> clients = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "Client", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Client client = new Client();
                client.setClientID(rs.getInt("ClientID"));
                client.setFirstName(rs.getString("FirstName"));
                client.setLastName(rs.getString("LastName"));
                client.setAge(rs.getInt("Age"));
                client.setPhone(rs.getString("Phone"));
                client.setEmail(rs.getString("Email"));
                client.setDateOfFirstPurchase(rs.getTimestamp("DateOfFirstPurchase"));
                clients.add(client);
            }
            
            return clients;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== PRODUCT ==========
    public static List<Product> selectProduct(List<String> columns, List<String> conditions, 
                                             String orderKey, String orientation, 
                                             String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "Product", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setDescription(rs.getString("Description"));
                product.setCategory(rs.getString("Category"));
                product.setUnitPrice(rs.getDouble("UnitPrice"));
                product.setLowStockThreshold(rs.getInt("LowStockThreshold"));
                product.setUnit(rs.getString("Unit"));
                products.add(product);
            }
            
            return products;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== SUPPLIER ==========
    public static List<Supplier> selectSupplier(List<String> columns, List<String> conditions, 
                                               String orderKey, String orientation, 
                                               String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Supplier> suppliers = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "Supplier", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplierID(rs.getInt("SupplierID"));
                supplier.setCompanyName(rs.getString("CompanyName"));
                supplier.setContactPerson(rs.getString("ContactPerson"));
                supplier.setPhone(rs.getString("Phone"));
                supplier.setEmail(rs.getString("Email"));
                supplier.setAddress(rs.getString("Address"));
                supplier.setDateOfFirstContact(rs.getTimestamp("DateOfFirstContact"));
                suppliers.add(supplier);
            }
            
            return suppliers;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== STOCK ==========
    public static List<Stock> selectStock(List<String> columns, List<String> conditions, 
                                         String orderKey, String orientation, 
                                         String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Stock> stocks = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "Stock", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Stock stock = new Stock();
                stock.setStockID(rs.getInt("StockID"));
                stock.setProductID(rs.getInt("ProductID"));
                stock.setCurrentQuantity(rs.getInt("CurrentQuantity"));
                stock.setLastUpdated(rs.getTimestamp("LastUpdated"));
                stocks.add(stock);
            }
            
            return stocks;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== SALE ==========
    public static List<Sale> selectSale(List<String> columns, List<String> conditions, 
                                       String orderKey, String orientation, 
                                       String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sale> sales = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "Sale", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Sale sale = new Sale();
                sale.setSaleID(rs.getInt("SaleID"));
                sale.setEmployeeID(rs.getInt("EmployeeID"));
                sale.setClientID(rs.getInt("ClientID"));
                sale.setSaleDate(rs.getTimestamp("SaleDate"));
                sale.setTotalAmount(rs.getDouble("TotalAmount"));
                sales.add(sale);
            }
            
            return sales;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== SALE LINE ==========
    public static List<SaleLine> selectSaleLine(List<String> columns, List<String> conditions, 
                                               String orderKey, String orientation, 
                                               String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<SaleLine> saleLines = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "SaleLine", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                SaleLine saleLine = new SaleLine();
                saleLine.setSaleLineID(rs.getInt("SaleLineID"));
                saleLine.setSaleID(rs.getInt("SaleID"));
                saleLine.setProductID(rs.getInt("ProductID"));
                saleLine.setQuantity(rs.getInt("Quantity"));
                saleLine.setUnitPrice(rs.getFloat("UnitPrice"));
                saleLines.add(saleLine);
            }
            
            return saleLines;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== SUPPLY ORDER ==========
    public static List<SupplyOrder> selectSupplyOrder(List<String> columns, List<String> conditions, 
                                                     String orderKey, String orientation, 
                                                     String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<SupplyOrder> supplyOrders = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "SupplyOrder", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                SupplyOrder supplyOrder = new SupplyOrder();
                supplyOrder.setSupplyOrderID(rs.getInt("SupplyOrderID"));
                supplyOrder.setEmployeeID(rs.getInt("EmployeeID"));
                supplyOrder.setSupplierID(rs.getInt("SupplierID"));
                supplyOrder.setOrderDate(rs.getTimestamp("OrderDate"));
                supplyOrder.setStatus(rs.getString("Status"));
                supplyOrder.setTotalAmount(rs.getDouble("TotalAmount"));
                supplyOrders.add(supplyOrder);
            }
            
            return supplyOrders;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== ORDER LINE ==========
    public static List<OrderLine> selectOrderLine(List<String> columns, List<String> conditions, 
                                                 String orderKey, String orientation, 
                                                 String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<OrderLine> orderLines = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "OrderLine", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                OrderLine orderLine = new OrderLine();
                orderLine.setSupplyLineID(rs.getInt("SupplyLineID"));
                orderLine.setSupplyOrderID(rs.getInt("SupplyOrderID"));
                orderLine.setProductID(rs.getInt("ProductID"));
                orderLine.setQuantity(rs.getInt("Quantity"));
                orderLine.setUnitPrice(rs.getFloat("UnitPrice"));
                orderLines.add(orderLine);
            }
            
            return orderLines;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
    
    // ========== EMPLOYEE AUTH ==========
    public static List<EmployeeAuth> selectEmployeeAuth(List<String> columns, List<String> conditions, 
                                                       String orderKey, String orientation, 
                                                       String limit) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EmployeeAuth> employeeAuths = new ArrayList<>();
        
        try {
            connection = Database.getConnection();
            stmt = buildSelectStatement(connection, "EmployeeAuth", columns, conditions, orderKey, orientation, limit);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                EmployeeAuth employeeAuth = new EmployeeAuth();
                employeeAuth.setEmployeeID(rs.getInt("EmployeeID"));
                employeeAuth.setLoginName(rs.getString("LoginName"));
                employeeAuth.setPasswordHash(rs.getString("PasswordHash"));
                employeeAuth.setLastLogin(rs.getTimestamp("LastLogin"));
                employeeAuth.setIsActive(rs.getBoolean("IsActive"));
                employeeAuths.add(employeeAuth);
            }
            
            return employeeAuths;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
    }
}