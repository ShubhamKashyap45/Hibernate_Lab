package com.demo.dao;

import java.util.List;

import com.demo.beans.Department;

public interface DepartmentDao {

	boolean saveDepartment(Department d);

	boolean removeById(int deptid);

	boolean updateById(int deptid, String dname, String loc);

	Department getById(int deptid);

	List<Department> getAll();

	List<Department> arrangeById();

	void shutdownSessionFactory();

}
