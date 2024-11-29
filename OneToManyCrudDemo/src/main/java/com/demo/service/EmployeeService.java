package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	boolean addEmployee();

	boolean deleteById(int eid);

	boolean modifyById(int eid, String name, double sal, int deptid);

	Employee displayById(int eid);

	List<Employee> diplayAll();

	List<Employee> sortById();

	void closeSessionFactory();

}
