package com.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="faculty11")
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int fid;
	private String fname;
	private String addr;
	
//	this annotation is used for forcefully lazy fetching bcz  int onetooone relation eager fetching is done by default 
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	
//	this annotation is used for give column name
	@JoinColumn(name="cid")
	private Course c1;

	public Faculty() {
		super();
	}

	public Faculty(String fname, String addr, Course c1) {
		super();
		this.fname = fname;
		this.addr = addr;
		this.c1 = c1;
	}

	
	public Faculty(int fid, String fname, String addr, Course c1) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.addr = addr;
		this.c1 = c1;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Course getC1() {
		return c1;
	}

	public void setC1(Course c1) {
		this.c1 = c1;
	}

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", addr=" + addr + "], c1=" + c1 +"]";
	}
	
	
	
	
	
}
