package com.veer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.veer.model.Customer;
import com.veer.model.Product;

public class ManyToManyMain {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Customer customer = new Customer();
		Customer customer2 = new Customer();
		Customer customer3 = new Customer();
		Customer customer4 = new Customer();
		
		
				
		customer.setCustName("Virendra Matal");
		customer.setCustEmail("virendra@gjmail.com");
		
		customer2.setCustName("Veer Matal");
		customer2.setCustEmail("veer@gmail.com");
		
		customer3.setCustName("Amit Matal");
		customer3.setCustEmail("amit@gmail.com");
		
		customer4.setCustName("Rohan Matal");
		customer4.setCustEmail("rohan@gmail.com");
		
		Product product = new Product();
		Product product2 = new Product();
		Product product3 = new Product();	
		Product product4 = new Product();
		
		product.setProductName("Iphone 13 Pro");
		product.setProductPrice(100000);
		
		product4.setProductName("Iphone 11 Pro");
		product4.setProductPrice(80000);
		
		product3.setProductName("Samsung J7");
		product3.setProductPrice(10000);
		
		product2.setProductName("Realme 7 Pro");
		product2.setProductPrice(20000);
		
		
		List<Customer> custlist1 = new ArrayList<Customer>();
		List<Customer> custlist2 = new ArrayList<Customer>();
		List<Customer> custlist3 = new ArrayList<Customer>();
		List<Product> productlist1 = new ArrayList<Product>();
		List<Product> productlist2 = new ArrayList<Product>();
		List<Product> productlist3 = new ArrayList<Product>();	
		
		custlist1.add(customer);
		custlist1.add(customer2);
		
		custlist2.add(customer3);
		custlist2.add(customer4);
		
		custlist3.add(customer);
		custlist3.add(customer4);	
		
		productlist1.add(product);
		productlist1.add(product2);
		
		productlist2.add(product3);
		productlist2.add(product4);
		
		productlist3.add(product);
		productlist3.add(product4);	
		
		customer.setProducts(productlist1);
		customer2.setProducts(productlist2);
		customer3.setProducts(productlist3);
		product.setCustomers(custlist1);
		product2.setCustomers(custlist2);
		product3.setCustomers(custlist3);
		
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		session.save(customer);
//		session.save(customer2);
//		session.save(customer3);
//		session.save(customer4);
//		session.save(product);
//		session.save(product2);
//		session.save(product3);
//		session.save(product4);
		
		
		Product loadedproduct = session.get(Product.class, 5);
		System.out.println("Product is : "+loadedproduct);
//		System.out.println("Customer is : "+loadedproduct.getCustomers());
		
//		Customer customer5 = session.get(Customer.class, 2);
//		System.out.println(customer5);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		

	}

}
