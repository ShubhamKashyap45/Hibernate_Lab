package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	boolean saveProduct(Product p);

	boolean removeById(int pid);

	List<Product> getAll();

	Product showById(int pid);

	boolean modifyById(int pid, int qty, double price);

	List<Product> arrangeByName();

	void shutdownSessionFactory();

}
