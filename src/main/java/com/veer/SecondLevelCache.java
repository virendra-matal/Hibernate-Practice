package com.veer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.veer.model.Student;

public class SecondLevelCache {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//first session
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, 26);
		System.out.println(student);
		session.close();

		// second session
		Session session2 = sessionFactory.openSession();
		Student student2 = session2.get(Student.class, 26);
		System.out.println(student2);
		session2.close();

		sessionFactory.close();
	}

}
