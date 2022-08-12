package com.veer;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.veer.model.Answer;
import com.veer.model.Question;

public class OneToManyMain {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Question question = new Question();
		question.setQuestion("which anotation is used to inject dependency of another class in corrunt class ?");
		
		Answer answer = new Answer();
		answer.setAnswer("@Inject");
		answer.setQuestion(question);
		
		Answer answer2 = new Answer();
		answer2.setAnswer("@Autowired");
		answer2.setQuestion(question);
		
		Answer answer3 = new Answer();
		answer3.setAnswer("@Id");
		answer3.setQuestion(question);
		
		Answer answer4 = new Answer();
		answer4.setAnswer("@Entity");
		answer4.setQuestion(question);
		
		ArrayList<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer2);
		list.add(answer3);
		list.add(answer4);
		
		question.setAnswer(list);
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(question);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();

	}

}
