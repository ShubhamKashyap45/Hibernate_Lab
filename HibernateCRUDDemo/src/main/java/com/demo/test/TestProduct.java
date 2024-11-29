package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProduct {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		ProductService ps=new ProductServiceImpl();
		do {
			System.out.println("1.Add Product..");
			System.out.println("2.DeleteById..");
			System.out.println("3.Display all Product..");
			System.out.println("4.DisplayById..");
			System.out.println("5.UpdateById..");
			System.out.println("6. SortByName..");
			System.out.println("7.Exit");
			System.out.println("Choice: ");
			
			choice=sc.nextInt();
			
			switch(choice) {
			
			case 1:
				boolean status=ps.addProduct();
				if(status) {
					System.out.println("Product Added Successfully..");
				}else {
					System.out.println("Error Occured.");
				}
				break;
				
			case 2: 
				sc=new Scanner(System.in);
				int pid=sc.nextInt();
				status =ps.deleteById(pid);
				if(status) {
					System.out.println("Product deleted sucessfully...");
				}else {
					System.out.println("Product not found..");
				}
				break;

			case 3: 
				List<Product> plist = ps.displayAll();
				plist.forEach(System.out::println);
				break;

			case 4:
				System.out.println("Enter Product id: ");
				pid=sc.nextInt();
				Product p= ps.displayById(pid);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("not found..");
				}
				
				break;

			case 5: 
				System.out.println("Enter your pid");
				pid = sc.nextInt();
				System.out.println("Enter new qty");
				int qty = sc.nextInt();
				System.out.println("Enter new Price");
				double price = sc.nextDouble();
				
				status = ps.updateById(pid, qty, price);
				if(status) {
					System.out.println("Updated Successfully");
				} else {
					System.out.println("Id Not found");
				}
				break;

			case 6: 
				plist = ps.sortByName();
				if(plist != null) {
					plist.forEach(System.out::println);
				} else {
					System.out.println("Table Empty");
				}
				break;

			case 7:
				System.out.println("Thank you for Visiting......");
				sc.close();
				ps.closeSessionFactory();
				break;
			default:
				System.out.println("wrong choice");
				break;
				
			}
			
		}while(choice!=7);
	}
}
