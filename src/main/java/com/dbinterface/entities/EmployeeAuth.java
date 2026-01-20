package com.dbinterface.entities;

import java.sql.Timestamp;

public class EmployeeAuth {
    private int EmployeeID;
    private String loginName;
    private String passwordHash;
    private Timestamp lastLogin;
    private boolean isActive;

    // Constructors
    public EmployeeAuth() {}

    public EmployeeAuth(int EmployeeID, String loginName, String passwordHash) {
        this.EmployeeID = EmployeeID;
        this.loginName = loginName;
        this.passwordHash = passwordHash;
        this.isActive = true;
    }

    // Getters and Setters
    public int getEmployeeID() { return EmployeeID; }
    public void setEmployeeID(int EmployeeID) { this.EmployeeID = EmployeeID; }
    
    public String getLoginName() { return loginName; }
    public void setLoginName(String loginName) { this.loginName = loginName; }
    
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    
    public Timestamp getLastLogin() { return lastLogin; }
    public void setLastLogin(Timestamp lastLogin) { this.lastLogin = lastLogin; }
    
    public boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    @Override
    public String toString() {
        return "EmployeeAuth{" +
                "EmployeeID=" + EmployeeID +
                ", loginName='" + loginName + '\'' +
                ", lastLogin=" + lastLogin +
                ", isActive=" + isActive +
                '}';
    }
}