package it.lorenzomiscoli.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@EmbeddedId
	private EmployeeId employeeId;

	public Employee() {

	}

	public Employee(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

}
