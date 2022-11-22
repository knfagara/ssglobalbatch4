package org.ssglobal.training.codes;

import java.util.List;
import java.util.stream.Stream;

public class EmployeeRepository {
	
	private List<Employee> employeetbl;
	
	public EmployeeRepository(List<Employee> employeetbl) {
		this.employeetbl = employeetbl;
	}
	
	
	// CRUD transactions
	
	public List<Employee> getEmployees(){
		return this.employeetbl;
	}
	
	public Stream<Employee> getEmployeesStream(){
		return this.employeetbl.stream();
	}

}
