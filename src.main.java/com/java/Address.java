package com.java;


public class Address {	
	
	private int idA;	
	private String country;	
	private String street;	
	private int zipCode;	
	private User user;
	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [idA=" + idA + ", country=" + country + ", street=" + street + ", zipCode=" + zipCode
				+ ", user=" + user + "]";
	}
	
	

}
