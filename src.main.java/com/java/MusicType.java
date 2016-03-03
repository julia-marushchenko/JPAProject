package com.java;

import java.util.Set;


public class MusicType {
	
	private int idM;	
	private String typeName;	
	private Set<User> users;
	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "MusicType [idM=" + idM + ", typeName=" + typeName + ", users=" + users + "]";
	}
	
	

}
