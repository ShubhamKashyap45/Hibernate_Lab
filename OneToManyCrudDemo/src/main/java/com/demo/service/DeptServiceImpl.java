package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.dao.DepartmentDao;
import com.demo.dao.DepartmentDaoImpl;

public class DeptServiceImpl implements DeptService {

	DepartmentDao ddao;

	public DeptServiceImpl() {
		super();
		this.ddao = new DepartmentDaoImpl();
	}

	public boolean addDepartment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enetr deptid");
		int deptid = sc.nextInt();
		System.out.println("enetr dname");
		String dnm = sc.next();
		System.out.println("enetr location");
		String dloc = sc.next();
		Department d = new Department(deptid, dnm, dloc, null);
		return ddao.saveDepartment(d);
	}

	public boolean deleteById(int deptid) {
		return ddao.removeById(deptid);
	}

	public boolean modifyById(int deptid, String dname, String loc) {
		return ddao.updateById(deptid, dname, loc);
	}

	public Department displayById(int deptid) {
		
		return ddao.getById(deptid);
	}

	@Override
	public List<Department> diplayAll() {
		
		return ddao.getAll();
	}

	@Override
	public List<Department> sortById() {
		
		return ddao.arrangeById();
	}

	@Override
	public void closeSessionFactory() {
		ddao.shutdownSessionFactory();
		
	}

}
