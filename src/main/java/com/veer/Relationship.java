package com.veer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.veer.model.Employee;
import com.veer.model.EmployeeAddress;

public class Relationship {

	public static void main(String[] args) {
		
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Employee employee = new Employee();
		employee.setEmplName("veer Matal");
		employee.setEmpPhone("1478523690");
		employee.setEmpEmail("veer@gmail.com");
		//creating amp address object
		
		EmployeeAddress address = new EmployeeAddress();
		address.setStreet("122, Station road, ");
		address.setCity("Nalasopara");
		address.setState("Maharashtra");
		address.setPincode("147852");
		//setting Employee in Address
		address.setEmployee(employee);
		//setting address in Employee...
		employee.setAddress(address);
		
		EmployeeAddress address2 = new EmployeeAddress(4,"122, Station road, near shiv temple","Nalasopara","Maharashtra","147852");
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		session.save(employee);
		session.update(address2);
		
		transaction.commit();
		
		Employee employee2 = session.get(Employee.class, 3);
		System.out.println(employee2+" Address is :  "+employee2.getAddress());
		System.out.println(" Address is :  "+employee2.getAddress().getCity());
		
		
		session.close();
		
		sessionFactory.close();

	}

}
