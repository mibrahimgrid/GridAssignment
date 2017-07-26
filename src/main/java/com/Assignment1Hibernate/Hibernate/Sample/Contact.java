package com.Assignment1Hibernate.Hibernate.Sample;


public class Contact implements java.io.Serializable
{
	private int id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String gender;
	private String phoneNumber;
	private boolean status;
	private Address address;
	private Account account;
	public Contact(){}
	public Contact( int id,String fname,String lname,String eaddr,String gender,String phnumber,boolean status, Address addr,Account acc)
	{
		this.id = id;
		this.firstName = fname;
		this.lastName = lname;
		this.emailAddress = eaddr;
		this.gender = gender;
		this.phoneNumber = phnumber;
		this.status = status;
		this.address = addr;
		this.account = acc;
		
	}
	public void ToString()
	{
		
		System.out.println(id+", "+firstName+" "+lastName+", "+emailAddress+", "+gender+", "+phoneNumber+","+status+","+address.getId()+","+account.getId());
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}

