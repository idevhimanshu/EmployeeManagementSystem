package com.jdbcDemo;

import java.sql.*;
public class DatabaseConnection {
	private static final String url = "jdbc:mysql://localhost:3306/employeedb";
	private static final String user = "root";
	private static final String pass = "12345";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection establish");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
