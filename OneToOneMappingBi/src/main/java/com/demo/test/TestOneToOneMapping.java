package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Faculty;

public class TestOneToOneMapping {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
//		set data from object to table
//		Course c = new Course();
//		c.setCname("Java");
//		c.setDuration(90);
//
//	    Faculty f = new Faculty("Anuj", "ccccc", c);
//		c.setF(f);
//		Session sess = sf.openSession();
//		Transaction tr = sess.beginTransaction();
//		sess.save(c);
//		sess.save(f);
//		tr.commit();
//		sess.close();
		

		  Session sess1=sf.openSession(); 	  Transaction tr1=sess1.beginTransaction();
////		  retrieve data
		  Course c=sess1.get(Course.class, 1); 
		  if(c!=null) { 
			  sess1.delete(c);   //exception occur 
			 }
		  tr1.commit(); 
		  sess1.close();
		 
		sf.close();
	}

}
