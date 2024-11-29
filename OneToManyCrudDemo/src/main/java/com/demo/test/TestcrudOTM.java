package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Department;
import com.demo.beans.Employee;
import com.demo.service.DeptService;
import com.demo.service.DeptServiceImpl;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class TestcrudOTM {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeService eservice=new EmployeeServiceImpl();
		DeptService dservice=new DeptServiceImpl();
		int choice=0;
		
		do {
			System.out.println("1. Add new Employee\n2. Add new Department\n");
			System.out.println("3. delete employee\n4. delete Department\n");
			System.out.println("5. modify employee\n6. modify Department\n");
			System.out.println("7. display  employee by id\n8. display Department by id\n");
			System.out.println("9. display all employee\n10. display all Department\n");
			System.out.println("11. display all employee in sorted order\n12. exit\nchoice :");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: 
				boolean status=eservice.addEmployee();
				if(status) {
					System.out.println("Employee Added Successfully..");
				}else {
					System.out.println("Error Occured.");
				}
				break;
				
			case 2: 
				status=dservice.addDepartment();
				if(status) {
					System.out.println("Department Added Successfully..");
				}else {
					System.out.println("Error Occured.");
				}
				break;
				
			case 3: 
				System.out.println("Enter id:");
				int eid = sc.nextInt();
				status = eservice.deleteById(eid);
				if(status) {
					System.out.println("Id deleted Successfully");
				} else {
					System.out.println("Not found");
				}
				break;
			case 4: 
				System.out.println("Enter id:");
				int deptid = sc.nextInt();
				status = dservice.deleteById(deptid);
				if(status) {
					System.out.println("Id deleted Successfully");
				} else {
					System.out.println("Not found");
				}
				break;
			case 5: 
				System.out.println("Enter id: ");
				eid = sc.nextInt();
				System.out.println("Enter Name: ");
				String name = sc.next();
				System.out.println("Enter salary: ");
				double sal = sc.nextDouble();
				System.out.println("Enter department Id: ");
				deptid = sc.nextInt();
				
				status=eservice.modifyById(eid,name,sal,deptid);
				if(status) {
					System.out.println("updated successfully");
				}else {
					System.out.println("not found");
				}
				break;
			case 6: 
				System.out.println("Enter dept id: ");
				deptid = sc.nextInt();
				System.out.println("Enter dept name: ");
				String dname = sc.next();
				System.out.println("Enter Location: ");
				String loc = sc.next();
				
				status=dservice.modifyById(deptid,dname,loc);
				if(status) {
					System.out.println("updated successfully");
				}else {
					System.out.println("not found");
				}
				break;
			case 7: 
				System.out.println("Enter employee id: ");
				eid= sc.nextInt();
				Employee e= eservice.displayById(eid);
				if(e!=null) {
					System.out.println(e);
				}else
				{
					System.out.println("not found");
				}
				
				break;
			case 8: 
				System.out.println("Enter department id: ");
				deptid= sc.nextInt();
				Department d= dservice.displayById(deptid);
				if(d!=null) {
					System.out.println(d);
				}else
				{
					System.out.println("not found");
				}
				
				break;
			case 9: 
				List<Employee> elist=eservice.diplayAll();
				elist.forEach(System.out::println);
				break;
			case 10: 
				List<Department> dlist=dservice.diplayAll();
				dlist.forEach(System.out::println);
				break;
			case 11: 
				 elist=eservice.sortById();
				elist.forEach(System.out::println);
				break;
			case 12: 
				dlist=dservice.sortById();
				dlist.forEach(System.out::println);
				break;
			case 13:
				System.out.println("Thank you for Visiting......");
				sc.close();
				eservice.closeSessionFactory();
				dservice.closeSessionFactory();
				break;
			default:
				System.out.println("wrong choice");
				break;
				
			}
		}while(choice!=12);
	}
	
}