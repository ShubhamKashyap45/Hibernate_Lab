//package com.demo.test;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import com.demo.beans.Product;
//import com.demo.beans.Student;
//public class TestStudent {
//
//	public static void main(String[] args) {
//		SessionFactory sf=new Configuration().configure().buildSessionFactory();
//		Session sess=sf.openSession();
//		Transaction tr=sess.beginTransaction();
//		
//		Student s=new Student(1,"Raj","1234567891",88);
//		Student s1=new Student("Raj","1234567891",88);
//		Product p=new Product("Chair",3,1200);
//		sess.save(s1);
//		sess.save(p);
//		sess.close();
//		tr.commit();
//        sf.close();
//	}
//
//}
