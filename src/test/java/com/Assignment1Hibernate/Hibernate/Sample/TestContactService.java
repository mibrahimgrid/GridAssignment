package com.Assignment1Hibernate.Hibernate.Sample;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestContactService 
{
	private static ContactService contactService;
	private static AddressService addressService;
	private static AccountService accountService;
	
	@BeforeClass
	public static void start()
	{
		contactService = new ContactService();
		addressService = new AddressService();
		accountService = new AccountService();
	}
	@Before
	public void clear()
	{
		
		contactService.deleteAll();
		addressService.deleteAll();
		accountService.deleteAll();
	}
	//test addressDao object
	@Test
	public void testContactDaoObject() 
	{
		assertNotNull(contactService.contactDao());
	}
	//test persist method
	@Test
	public void testPersists()
	{
		Address address = new Address(50,"TestAdddress","TestCity","TestProvince","TestCountery");
		addressService.persist(address);
		
		Account account = new Account(50,"TestName","TestEmail","GMT+5");
		accountService.persist(account);
		
		Contact contact = new Contact(50,"TestFName","TestLName","Test@email","Gender","phnumber",true,address, account);
		contactService.persist(contact);
		
		Contact getContact = contactService.findById(contact.getId());
		assertEquals(getContact.getId(),contact.getId());
		
	}
	
	@Test
	public void testFindById()
	{
		Address address = new Address(51,"TestAdddress","TestCity","TestProvince","TestCountery");
		addressService.persist(address);
		
		Account account = new Account(51,"TestName","TestEmail","GMT+5");
		accountService.persist(account);
		
		Contact contact = new Contact(51,"TestFName","TestLName","Test@email","Gender","phnumber",true,address, account);
		contactService.persist(contact);
		
		Contact getContact = contactService.findById(contact.getId());
		assertEquals(getContact.getId(),contact.getId());
	}
	
	@Test
	public void testUpdate()
	{
		String updatedValue = "test@globalrescue.com";
		Address address = new Address(51,"TestAdddress","TestCity","TestProvince","TestCountery");
		addressService.persist(address);
		
		Account account = new Account(51,"TestName","TestEmail","GMT+5");
		accountService.persist(account);
		
		Contact contact = new Contact(51,"TestFName","TestLName","Test@email","Gender","phnumber",true,address, account);
		contactService.persist(contact);
		
		
		contact.setEmailAddress(updatedValue);
		contactService.update(contact);
		Contact getContact = contactService.findById(contact.getId());
		assertEquals(getContact.getEmailAddress(),contact.getEmailAddress());
	}
	@Test
	public void findAll()
	{
		contactService.deleteAll();
		List<Contact> contacts = new ArrayList<Contact>();
		
		for(int i=20; i<25; i++)
		{
			String name = "Acccount"+ i+1;
        	String mail = name+"@globalrescue.com";
        	String timezone = "GMT+5";
        	Account acc1 = new Account(i+1,name,mail,timezone);
        	
        	accountService.persist(acc1);
        	
        	
        	//--------------------------------
        	String stAddr = "address"+ i+1;
        	
        	Address addr = new Address(i+1,stAddr,"DGK","Punjab","Pakistan");
        	
        	
        	addressService.persist(addr);
        	//---------------------------------
        	
        	String fname = "first"+i+1;
        	String lname = "last"+i+1;
        	String email = fname+lname+"@globalrescue.com";
        	Contact c = new Contact(i+1,fname,lname,email,"Male","+923417889364",true,addr,acc1);
        	contacts.add(c);
        	contactService.persist(c);
		}
		List<Contact> getContacts = contactService.findAll();
		
		for(int i=0; i<5; i++)
		{
			assertEquals(contacts.get(i).getId(),getContacts.get(i).getId());
		}
	}
	@Test
	public void testDelete()
	{
		Address address = new Address(51,"TestAdddress","TestCity","TestProvince","TestCountery");
		addressService.persist(address);
		
		Account account = new Account(51,"TestName","TestEmail","GMT+5");
		accountService.persist(account);
		
		Contact contact = new Contact(51,"TestFName","TestLName","Test@email","Gender","phnumber",true,address, account);
		contactService.persist(contact);
		
		
		contactService.delete(contact.getId());
		Contact getContact = contactService.findById(account.getId());
		assertNull(getContact);
		
	}
	
	@Test
	public void testDeleteAll()
	{
		for(int i=20; i<25; i++)
		{
			String name = "Acccount"+ i+1;
        	String mail = name+"@globalrescue.com";
        	String timezone = "GMT+5";
        	Account acc1 = new Account(i+1,name,mail,timezone);
        	
        	accountService.persist(acc1);
        	
        	
        	//--------------------------------
        	String stAddr = "address"+ i+1;
        	
        	Address addr = new Address(i+1,stAddr,"DGK","Punjab","Pakistan");
        	
        	
        	addressService.persist(addr);
        	//---------------------------------
        	
        	String fname = "first"+i+1;
        	String lname = "last"+i+1;
        	String email = fname+lname+"@globalrescue.com";
        	Contact c = new Contact(i+1,fname,lname,email,"Male","+923417889364",true,addr,acc1);
        	
        	contactService.persist(c);
		}
		contactService.deleteAll();
		
		List<Contact> contacts = contactService.findAll();
		
		assertEquals(contacts.size(),0);
	}

}
