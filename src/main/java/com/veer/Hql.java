package com.veer;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.veer.model.Answer;
import com.veer.model.Customer;

public class Hql {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		String hql = "delete from Student s where s.name=:name";
		String hql2 = "update from Student s set s.name=:name where s.city=:city";
		String hql3 = "SELECT c.custId, c.custName, p.productName FROM Customer c INNER JOIN c.products p where c.custName=:name";
		String hql4 = "from Answer";
		Query<Object[]> query = session.createQuery(hql3, Object[].class);
		query.setParameter("name", "Veer Matal");
		// query.setParameter("name", "Vicky Matal");
		// query.setParameter("city", "virar");
		// int No_Records = query.executeUpdate();

		List<Object[]> list = query.getResultList();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}

		// execute hql4 query
		Query<Answer> query2 = session.createQuery(hql4,Answer.class);
		// implementing pagination
		query2.setFirstResult(0);
		query2.setMaxResults(4);
		
		List<Answer> list2 = query2.list();
		for (Answer answer : list2) {
			System.out.println(answer);
		}

		
		
		//Executing Native SQL Query
		String sql="select * from answer";
		NativeQuery<Object[]> sqlQuery = session.createSQLQuery(sql);
		List<Object[]> list3 = sqlQuery.list();
		
		for (Object[] objects : list3) {
			System.out.println(Arrays.toString(objects));
		}
		
		transaction.commit();
		session.close();

	}

}
