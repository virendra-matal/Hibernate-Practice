package com.veer;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.veer.model.Address;
import com.veer.model.Answer;
import com.veer.model.Employee;
import com.veer.model.Student;

public class CriteriaAPI {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		
		Root<Student> student = query.from(Student.class);
		
		query.where(builder.equal(student.get("name"), "Virendra Matal"));
		//query.select(student).where(builder.like(student.get("name"), "%v%"));
		Query<Student> query2 = session.createQuery(query);
		List<Student> list = query2.list();
		
		for (Student st : list) {
			System.out.println(st);
		}
		
		Criteria criteria = session.createCriteria(Answer.class);
		criteria.add(Restrictions.eq("question.queId", 9));
		List<Answer> addresList = criteria.list();
		for (Answer object : addresList) {
			System.out.println(object);
		}
		
		session.close();

		
		
		factory.close();
	}

}
