package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	boolean addEmployee(Employee e);

	boolean removeById(int eid);

	boolean updateById(int eid, String name, double sal, int deptid);

	Employee getById(int eid);

	List<Employee> getAll();

	List<Employee> arrangeById();

	void shutdownSessionFactory();

}
