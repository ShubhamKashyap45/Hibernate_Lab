package com.demo.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class TestOneToManyBi {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
//		set data in obj department and employee
		Department d1=new Department();
		d1.setDeptid(1);
		d1.setDname("sales");
		d1.setDloc("pune");
		Department d2=new Department();
		d2.setDeptid(2);
		d2.setDname("HR");
		d2.setDloc("Goa");
		
		Employee e1=new Employee(1,"Rohan",12000,LocalDate.of(2024, 12, 1),d1);
		Employee e2=new Employee(2,"Ram",15000,LocalDate.of(2024, 11, 1),d2);
		Employee e3=new Employee(3,"Daksh",10000,LocalDate.of(2024, 10, 1),d2);
		Employee e4=new Employee(4,"Raj",10000,LocalDate.of(2024, 10, 1),d1);
		
		Set<Employee> s1= new HashSet<>();
		s1.add(e1);
		s1.add(e4);
		d1.setElist(s1);
		Set<Employee> s2= new HashSet<>();
		s2.add(e2);
		s2.add(e3);
		d2.setElist(s2);
		Session sess= sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(d1);
		sess.save(d2);
		sess.save(e1);
		sess.save(e2);
		sess.save(e3);
		sess.save(e4);
		
		tr.commit();
//		sess.close();
//		sf.close();
		
	}

}
