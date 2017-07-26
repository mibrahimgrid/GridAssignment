package com.Assignment1Hibernate.Hibernate.Sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Account implements java.io.Serializable
{
	private int id;
	private String name;
	private String email;
	private String timeZone;
	private Set<Contact> contacts;
	
	public Account(int id,String name, String email, String timezone)
	{
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.timeZone = timezone;
	}
	public Account(){}
	public void ToString()
	{
		System.out.println(id+", " +name+", "+email);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Set<Contact> getContacts() 
	{
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) 
	{
		this.contacts = contacts;
	}
		
}
