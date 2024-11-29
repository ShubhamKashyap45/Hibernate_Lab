package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao edao;
	public EmployeeServiceImpl() {
		super();
		this.edao = new EmployeeDaoImpl();
	}

	public boolean addEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee Id: ");
		int eid=sc.nextInt();
		System.out.println("Enter employee Name: ");
		String ename=sc.next();
		System.out.println("Enter employee sal: ");
		double sal=sc.nextInt();
		System.out.println("Enter employee doj: ");
		String doj=sc.next();
		LocalDate ldt=LocalDate.parse(doj,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("enter deptid");
		int deptid=sc.nextInt();
		Employee e= new Employee(eid,ename,sal,ldt,new Department(deptid));
		return edao.addEmployee(e);
	}

	public boolean deleteById(int eid) {
		return edao.removeById(eid);
	}

	public boolean modifyById(int eid, String name, double sal, int deptid) {
		return edao.updateById(eid, name, sal, deptid);
	}

	public Employee displayById(int eid) {
		return edao.getById(eid);
	}

	@Override
	public List<Employee> diplayAll() {
		
		return edao.getAll();
	}

	@Override
	public List<Employee> sortById() {
		
		return edao.arrangeById();
	}
	
	 public void closeSessionFactory() {
		 edao.shutdownSessionFactory();
	}

}
