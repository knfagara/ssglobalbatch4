package org.ssglobal.training.codes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ssglobal.training.codes.Employee;
import org.ssglobal.training.codes.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployeeRepository {
	
	private EmployeeRepository repo;
	
	@BeforeEach
	public void setup() {
		Employee emp1 = new Employee(101, "Maria", "Cruz", 50000.00);
		Employee emp2 = new Employee(102, "Juan", "Luna", 40000.00);
		
		List<Employee> records = Arrays.asList(emp1, emp2);
		repo = new EmployeeRepository(new ArrayList<>(records));
	}
	
	@AfterEach
	public void teardown() {
		repo = null;
	}
	
	@Test
	public void testGetEmployees() {
		List<Employee> actualRec = repo.getEmployees();
		List<String> expectedListNames = Arrays.asList("Maria", "Juan");
		double expectedAvgSalary = 45000.00;
		assertAll(() -> {
			assertIterableEquals(expectedListNames, actualRec.stream()
					.map((rec) -> { return rec.firstname();})
					.collect(Collectors.toList()));
		},
				  () -> {
			assertEquals(expectedAvgSalary, actualRec.stream()
					.map((rec) -> {return rec.Salary();})
					.mapToDouble(Double::doubleValue)
					.average()
					.getAsDouble());
	     });
	}

}
