package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOneMapping {

	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Course c=new Course("java",90);
		Faculty f=new Faculty("Anuj","XXX",c);
//		add faculty and course objects in a table
		
//		Session sess= sf.openSession();
//		Transaction tr=sess.beginTransaction();
//		sess.save(c);
//		sess.save(f);
//		tr.commit();
//		sess.close();
		
//		create new session for retrieving data from faculty and course table
		Session sess1=sf.openSession();
		Faculty f1= sess1.get(Faculty.class, 1);
		System.out.println(f1);
		
		Course c1=sess1.get(Course.class, 5);
		System.out.println(c1);
		sf.close();
		
		

	}

}
