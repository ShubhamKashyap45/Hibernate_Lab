package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	boolean addProduct();

	boolean deleteById(int pid);

	List<Product> displayAll();

	Product displayById(int pid);

	boolean updateById(int pid, int qty, double price);

	List<Product> sortByName();

	void closeSessionFactory();

}
