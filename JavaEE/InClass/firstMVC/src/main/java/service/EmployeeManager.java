package service;

//import org.springframework.beans.factory.annotation.Autowired;

import model.employee;

public class EmployeeManager {

	//@Autowired
	private employee employee;

	public employee getEmployee() {
		return employee;
	}

	public void setEmployee(employee employee) {
		this.employee = employee;
	}
	
	public String callEmployeeManager() {
		return employee.toString();
	}
}
