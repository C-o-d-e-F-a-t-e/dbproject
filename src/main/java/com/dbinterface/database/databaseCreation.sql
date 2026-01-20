CREATE DATABASE Pharmacy;
USE Pharmacy; 
CREATE TABLE Employee (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Age INT NOT NULL,
    Phone VARCHAR(15) NOT NULL UNIQUE,
    Email VARCHAR(50) NOT NULL UNIQUE,
    Role VARCHAR(50) NOT NULL,
    DateOfEmployment DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE EmployeeAuth (
    EmployeeID INT PRIMARY KEY,
    LoginName VARCHAR(50) NOT NULL UNIQUE,
    PasswordHash VARCHAR(255) NOT NULL, #bcrypted
    LastLogin DATETIME,
    IsActive BOOLEAN DEFAULT TRUE,
    CONSTRAINT FK_EmployeeAuth_Employee FOREIGN KEY (EmployeeID)
        REFERENCES Employee(EmployeeID)
        ON DELETE CASCADE
);

CREATE TABLE Client (
    ClientID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Age INT NOT NULL,
    Phone VARCHAR(15) UNIQUE,
    Email VARCHAR(50) UNIQUE,
    DateOfFirstPurchase DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Supplier (
    SupplierID INT AUTO_INCREMENT PRIMARY KEY,
    CompanyName VARCHAR(100) NOT NULL,
    ContactPerson VARCHAR(50),
    Phone VARCHAR(15) UNIQUE,
    Email VARCHAR(100) UNIQUE,
    Address VARCHAR(255),
    DateOfFirstContact DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Product (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(50) NOT NULL,
    Description TEXT,
    Category VARCHAR(50) NOT NULL,
    UnitPrice DECIMAL(10,3) NOT NULL,
    LowStockThreshold INT DEFAULT 10,
    Unit VARCHAR(20)
);

CREATE TABLE Stock (
    StockID INT AUTO_INCREMENT PRIMARY KEY,
    ProductID INT UNIQUE,
    CurrentQuantity INT NOT NULL DEFAULT 0,
    LastUpdated DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_Stock_Product FOREIGN KEY (ProductID)
        REFERENCES Product(ProductID)
        ON DELETE CASCADE
);

CREATE TABLE Sale (
    SaleID INT AUTO_INCREMENT PRIMARY KEY,
    EmployeeID INT NOT NULL,
    ClientID INT,
    SaleDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    TotalAmount DECIMAL(10,3) NOT NULL,
    CONSTRAINT FK_Sale_Employee FOREIGN KEY (EmployeeID)
        REFERENCES Employee(EmployeeID),
    CONSTRAINT FK_Sale_Client FOREIGN KEY (ClientID)
        REFERENCES Client(ClientID)
);

CREATE TABLE SaleLine (
    SaleLineID INT AUTO_INCREMENT PRIMARY KEY,
    SaleID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL,
    UnitPrice FLOAT NOT NULL,
    CONSTRAINT FK_SaleLine_Sale FOREIGN KEY (SaleID)
        REFERENCES Sale(SaleID)
        ON DELETE CASCADE,
    CONSTRAINT FK_SaleLine_Product FOREIGN KEY (ProductID)
        REFERENCES Product(ProductID)
);

CREATE TABLE SupplyOrder (
    SupplyOrderID INT AUTO_INCREMENT PRIMARY KEY,
    EmployeeID INT NOT NULL,
    SupplierID INT NOT NULL,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    Status VARCHAR(20) DEFAULT 'pending', # pending, cancelled, done
    TotalAmount DECIMAL(10,3) NOT NULL,
    CONSTRAINT FK_SupplyOrder_Employee FOREIGN KEY (EmployeeID)
        REFERENCES Employee(EmployeeID),
    CONSTRAINT FK_SupplyOrder_Supplier FOREIGN KEY (SupplierID)
        REFERENCES Supplier(SupplierID)
);

CREATE TABLE OrderLine (
    SupplyLineID INT AUTO_INCREMENT PRIMARY KEY,
    SupplyOrderID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL,
    UnitPrice FLOAT NOT NULL,
    CONSTRAINT FK_OrderLine_SupplyOrder FOREIGN KEY (SupplyOrderID)
        REFERENCES SupplyOrder(SupplyOrderID)
        ON DELETE CASCADE,
    CONSTRAINT FK_OrderLine_Product FOREIGN KEY (ProductID)
        REFERENCES Product(ProductID)
);