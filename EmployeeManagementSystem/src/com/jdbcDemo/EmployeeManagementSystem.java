package com.jdbcDemo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementSystem {
	private static EmployeeDAO employeeDAO = new EmployeeDAO();
	public static void main(String[] args) {
		
		Employee employee = new Employee(0, "himanshu", "Devlopper", 10000);
		employeeDAO.addEmployee(employee);
		Employee employee1 = new Employee(0, "himanshu", "Devlopper", 10000);
		employeeDAO.updateEmployee(employee1);
		employeeDAO.deleteEmployee(employee1);
		List<Employee> employees = employeeDAO.allEmployees();
		for (Employee employee2 : employees) {
			System.out.println(employee2);
		}
	}
}
