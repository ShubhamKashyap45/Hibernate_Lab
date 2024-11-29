package com.demo.service;

import java.util.List;

import com.demo.beans.Department;

public interface DeptService {

	boolean addDepartment();

	boolean deleteById(int deptid);

	boolean modifyById(int deptid, String dname, String loc);

	Department displayById(int deptid);

	List<Department> diplayAll();

	List<Department> sortById();

	void closeSessionFactory();

}
