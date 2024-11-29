package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Course;
import com.demo.beans.Student;

public class TestManyToMany {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Student s1=new Student();
		s1.setSid(1);
		s1.setSname("Rohan");
		
		Student s2=new Student();
		s1.setSid(2);
		s1.setSname("Ram");
		
		Student s3=new Student();
		s1.setSid(3);
		s1.setSname("Raj");
		
		Student s4=new Student();
		s1.setSid(4);
		s1.setSname("Rajesh");
		
		Course c1=new Course();
		c1.setCid(100);
		c1.setCname("Java");
		
		Course c2=new Course();
		c2.setCid(200);
		c2.setCname("C++");
		
		Course c3=new Course();
		c3.setCid(300);
		c3.setCname("Python");
		
		Course c4=new Course();
		c4.setCid(400);
		c4.setCname("Perl");
//		sets of student
		Set<Student> sset1=new HashSet<>();
		sset1.add(s1);
		sset1.add(s2);
		sset1.add(s4);
		
		Set<Student> sset2=new HashSet<>();
		sset2.add(s2);
		sset2.add(s1);
		
		Set<Student> sset3=new HashSet<>();
		sset3.add(s3);
		sset3.add(s4);
	
		Set<Student> sset4=new HashSet<>();
		sset1.add(s4);
		
//		sets of course
		Set<Course> cset1=new HashSet<>();
		cset1.add(c1);
		cset1.add(c2);
		Set<Course> cset2=new HashSet<>();
		cset1.add(c3);
		cset1.add(c4);
		Set<Course> cset3=new HashSet<>();
		cset1.add(c1);
		cset1.add(c3);
		
		s1.setClist(cset1);
		s2.setClist(cset1);
		s3.setClist(cset2);
		s4.setClist(cset3);
		
		c1.setSlist(sset1);
		c2.setSlist(sset2);
		c3.setSlist(sset3);
		c4.setSlist(sset4);
		
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(c1);
		sess.save(c2);
		sess.save(c3);
		sess.save(c4);
		sess.save(s1);
		sess.save(s2);
		sess.save(s3);
		sess.save(s4);
		tr.commit();
		sess.close();
		sf.close();
	}

}
