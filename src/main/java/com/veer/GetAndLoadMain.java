package com.veer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.veer.model.Student;

public class GetAndLoadMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();

		Student student = session.get(Student.class, 1);
		System.out.println(student);

		Student student2 = session.load(Student.class, 3);
		System.out.println(student2);

		session.close();

	}

}
