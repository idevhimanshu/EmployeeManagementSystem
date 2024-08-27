package com.jdbcDemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDAO {
	
	private static Connection connection;
	
	public EmployeeDAO() {
		connection = DatabaseConnection.getConnection();
	}
	
	// Add employee in to the database
	
	public void addEmployee(Employee employee) {
		String sql = "INSERT INTO EMPLOYEES(name, department, salary) VALUES (?, ?, ?)";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, employee.getName());
			pStatement.setString(2, employee.getDepartment());
			pStatement.setDouble(3, employee.getSalary());
			int res  = pStatement.executeUpdate();
			System.out.println(res +" employee has been added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	public void updateEmployee(Employee employee) {
		String sql = "UPDATE EMPLOYEES SET name = ?, department = ?, salary = ? WHERE id = ?";
		PreparedStatement pStatement;
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, employee.getName());
			pStatement.setString(2, employee.getDepartment());
			pStatement.setDouble(3, employee.getSalary());
			pStatement.setInt(4, employee.getId());
			int res  = pStatement.executeUpdate();
			System.out.println(res +" employee has been added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteEmployee(Employee employee) {
		String sql = "DELETE FROM EMPLOYEES WHERE id = ?";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, employee.getId());
			pStatement.executeUpdate();
			System.out.println("delete employee successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<Employee> allEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * FROM EMPLOYEES";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("department"), resultSet.getDouble("salary"));
				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
}
