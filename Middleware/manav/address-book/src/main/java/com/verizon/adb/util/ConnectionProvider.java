package com.verizon.adb.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
@Component
//@Resource
@Scope("singleton")
public class ConnectionProvider {
	private String driverName;
	private String dbUrl;
	private  String dbUserName;
	private String dbPassword;
	//private static ConnectionProvider instance;

	public ConnectionProvider() throws ClassNotFoundException
	{
		driverName = "com.mysql.jdbc.Driver";
		dbUrl = "jdbc:mysql://localhost:3306/adb";
		dbUserName="root";
		dbPassword = "password";
		Class.forName(driverName);
		//Loading driver is a one time task
		
	}
	
	public Connection getConnection()throws SQLException{
		return DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

}
