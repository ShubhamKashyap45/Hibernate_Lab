package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	
	ProductDao pdao;
	
	public ProductServiceImpl() {
		super();
		this.pdao =new ProductDaoImpl();
	}


	public boolean addProduct() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Name: ");
		String pname=sc.next();
		System.out.println("Enter Product Qty: ");
		int qty=sc.nextInt();
		System.out.println("Enter Product Price: ");
		double price=sc.nextDouble();
		Product p= new Product(pname,qty,price);
		return pdao.saveProduct(p);
	}


	public boolean deleteById(int pid) {
		
		return pdao.removeById(pid);
	}


	@Override
	public List<Product> displayAll() {
		// TODO Auto-generated method stub
		
		return pdao.getAll();
	}


	@Override
	public Product displayById(int pid) {
		// TODO Auto-generated method stub
		return pdao.showById(pid);
	}


	@Override
	public boolean updateById(int pid, int qty, double price) {
		return pdao.modifyById(pid, qty, price);
	}


	@Override
	public List<Product> sortByName() {
		return pdao.arrangeByName();
	}


	@Override
	public void closeSessionFactory() {
		pdao.shutdownSessionFactory();
		
	}

}
