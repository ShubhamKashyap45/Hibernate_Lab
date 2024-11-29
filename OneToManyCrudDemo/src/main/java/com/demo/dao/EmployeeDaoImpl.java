package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	static SessionFactory sf;
	static {
		sf = HUtil.getMyConnection();
	}
	
	public void closeMyConnection() {
		HUtil.closeMyConnection();
	}

	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(e);
		//to search dept object
		Department d1=sess.load(Department.class,e.getD().getDeptid());
		e.setD(d1);
		sess.saveOrUpdate(e);
		tr.commit();
		sess.close();
		return false;
	}

	public boolean removeById(int eid) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Employee e = sess.get(Employee.class, eid);
		boolean status;
		if(e != null) {
			sess.delete(e);
			status= true;
		} else {
			
			status = false;
		}
		
		tr.commit();
		sess.close();
		return status;
	}

	public boolean updateById(int eid, String name, double sal, int deptid) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Employee e = sess.get(Employee.class, eid);
		boolean status=false;
		if(e != null) {
			e.setEname(name);
			e.setSal(sal);
			Department d = sess.get(Department.class, deptid);
			e.setD(d);
			sess.update(e);
			status= true;
			
		}
		tr.commit();
		sess.close();
		return status;
	}

	public Employee getById(int eid) {
        Session sess= sf.openSession();
        Transaction tr=sess.beginTransaction();
        Employee e= sess.get(Employee.class, eid);
        tr.commit();
        sess.close();
		return e;
	}

	@Override
	public List<Employee> getAll() {
		Session sess= sf.openSession();
        Transaction tr=sess.beginTransaction();
        Query q=sess.createQuery("from Employee");
        List<Employee> elist=q.getResultList();
        tr.commit();
        sess.close();
		return elist;
	}

	@Override
	public List<Employee> arrangeById() {
		Session sess= sf.openSession();
        Transaction tr=sess.beginTransaction();
        Query q=sess.createQuery("from Employee e order by e.eid ");
        List<Employee> elist=q.getResultList();
        tr.commit();
        sess.close();
		return elist;
	}
	
	@Override
	public void shutdownSessionFactory() {
		HUtil.closeMyConnection();
	}


}
