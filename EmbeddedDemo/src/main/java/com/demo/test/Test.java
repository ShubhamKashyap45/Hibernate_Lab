package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Student;
import com.demo.beans.Address;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		Address addr= new Address(100,"MP","Bhopal",476001);
		Student s = new Student(5,"Himanshi",78,addr);
		Student s1 = new Student(6,"Rohit",98,addr);
		Transaction tr = ss.beginTransaction();
		ss.save(s);
		ss.save(s1);
		tr.commit();
		sf.close();
	}

}
