package com.veer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String emplName;
	private String empPhone;
	private String empEmail;
	@OneToOne
	@JoinColumn(name = "address")
	private EmployeeAddress address;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empId, String emplName, String empPhone, String empEmail, EmployeeAddress address) {
		super();
		this.empId = empId;
		this.emplName = emplName;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.address = address;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public EmployeeAddress getAddress() {
		return address;
	}
	public void setAddress(EmployeeAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", emplName=" + emplName + ", empPhone=" + empPhone + ", empEmail="
				+ empEmail +"]";
	}
	
	
	
	
	
	
	
	
	

}
