package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	
	static SessionFactory sf;
	
	static {
		sf = HUtil.getMyConnection();
	}

	public boolean saveProduct(Product p) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(p);
		tr.commit();
		sess.close();
		return true;
	}

	public boolean removeById(int pid) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class , pid);
		
		boolean status;
		if(p!=null) {
			sess.delete(p);
			status= true;
		}else {
			status=false;
		}
		tr.commit();
		sess.close();
		return status;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Query<Product> query = sess.createQuery("from Product");
		List<Product> plist = query.getResultList();
		tr.commit();
		sess.close();
		return plist;
	}

	@Override
	public Product showById(int pid) {
		Session sess=sf.openSession();
		Transaction tr= sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		if(p!=null) {
			tr.commit();
			sess.close();
			return p;
		}
		sess.close();
		return null;
		
	}

	@Override
	public boolean modifyById(int pid, int qty, double price) {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Product p = sess.get(Product.class, pid);
		if(p != null) {
			p.setQty(qty);
			p.setPrice(price);
			sess.update(p);
			tr.commit();
			sess.close();
			return true;
		} 
		sess.close();
		return false;
	}

	@Override
	public List<Product> arrangeByName() {
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Query<Product> query = sess.createQuery("from Product p order by p.pname desc");
		List<Product> plist = query.getResultList();
		return plist;
	}

	@Override
	public void shutdownSessionFactory() {
		HUtil.closeMyConnection();
		
	}
}
