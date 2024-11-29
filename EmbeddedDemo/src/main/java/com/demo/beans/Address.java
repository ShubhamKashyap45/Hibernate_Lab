package com.demo.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private int addrId;
	private String state;
	private String city;
	private int pin;
	public Address() {
		super();
	}
	public Address(int addrId, String state, String city, int pin) {
		super();
		this.addrId = addrId;
		this.state = state;
		this.city = city;
		this.pin = pin;
	}
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", state=" + state + ", city=" + city + ", pin=" + pin + "]";
	}
	
	
}
