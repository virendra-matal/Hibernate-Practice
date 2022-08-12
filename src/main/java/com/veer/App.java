package com.veer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.veer.model.Address;
import com.veer.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        Student student = new Student();
        student.setName("Amit Matal");
        student.setPhone("1479632580");
        student.setCity("Virar");
        
        System.out.println(student);
        
        // creating address object
        
        Address address = new Address();
        address.setStreet("Virar Road");
        address.setCity("Virar");
        address.setState("Maharashtra");
        address.setPincode("159753");
        address.setAddressDate(new Date());
        address.setDesc("Hey this is just short description.");
        FileInputStream inputStream = new FileInputStream("src/main/java/com/veer/veer-photo.jpeg");
        byte[] data=new byte[inputStream.available()];
        inputStream.read(data);
        address.setImage(data);
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Serializable save = session.save(student);
        session.save(address);
        transaction.commit();
        
        session.close();
    }
}
