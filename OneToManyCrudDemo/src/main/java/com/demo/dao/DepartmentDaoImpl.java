package com.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Department;
import com.demo.beans.Employee;

public class DepartmentDaoImpl implements DepartmentDao {

	static SessionFactory sf;
	static {
		sf = HUtil.getMyConnection();
	}

	public boolean saveDepartment(Department d) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(d);
		tr.commit();
		sess.close();
		return true;

	}

	public boolean removeById(int id) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Department d = sess.get(Department.class, id);
		boolean status;
		if (d != null) {
			sess.delete(d);
			status = true;
		}
		status = false;
		tr.commit();
		sess.close();

		return status;
	}

	public boolean updateById(int deptid, String dname, String loc) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Department d = sess.get(Department.class, deptid);
		boolean status = false;
		if (d != null) {
			d.setDname(dname);
			d.setDloc(loc);
			sess.update(d);
			status = true;
		}
		tr.commit();
		sess.close();
		return status;
	}

	public Department getById(int deptid) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Department d = sess.get(Department.class, deptid);
		tr.commit();
		sess.close();
		return d;
	}

	@Override
	public List<Department> getAll() {
		Session sess= sf.openSession();
        Transaction tr=sess.beginTransaction();
        Query q=sess.createQuery("from Department");
        List<Department> dlist=q.getResultList();
        tr.commit();
        sess.close();
		return dlist;
	}

	@Override
	public List<Department> arrangeById() {
		Session sess= sf.openSession();
        Transaction tr=sess.beginTransaction();
        Query q=sess.createQuery("from Department d order by d.deptid ");
        List<Department> dlist=q.getResultList();
        tr.commit();
        sess.close();
		return dlist;
	}
	@Override
	public void shutdownSessionFactory() {
		HUtil.closeMyConnection();
		
	}


}
