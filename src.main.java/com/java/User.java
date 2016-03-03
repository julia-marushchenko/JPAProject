package com.java;

import java.util.Set;


public class User {	
	
	private int idU;		
	private String login;	
	private String password;	
	private String firstName;	
	private String lastName;	
	private int age;	
	private Address address;
	private Role roleUser;
	private Set <MusicType> musicTypes;
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Role getRoleUser() {
		return roleUser;
	}
	public void setRoleUser(Role roleUser) {
		this.roleUser = roleUser;
	}
	public Set<MusicType> getMusicTypes() {
		return musicTypes;
	}
	public void setMusicTypes(Set<MusicType> musicTypes) {
		this.musicTypes = musicTypes;
	}
	@Override
	public String toString() {
		return "User [idU=" + idU + ", login=" + login + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + ", address=" + address + ", roleUser=" + roleUser
				+ ", musicTypes=" + musicTypes + "]";
	}
	
	

}
