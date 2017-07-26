package com.Assignment1Hibernate.Hibernate.Sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	
        AddressService addressService = new AddressService();
        ContactService contactService = new ContactService();
        AccountService accountService = new AccountService();
        
        List<Account> accounts = new ArrayList<Account>();
        List<Address> addresses = new ArrayList<Address>();
        List<Contact> contatcs = new ArrayList<Contact>();
        
        for(int i=0; i< 5; i++)
        {
        	String name = "Acccount"+ i+1;
        	String mail = name+"@globalrescue.com";
        	String timezone = "GMT+5";
        	Account acc1 = new Account(i+1,name,mail,timezone);
        	accounts.add(acc1);
        	accountService.persist(acc1);
        	
        	
        	//--------------------------------
        	String stAddr = "address"+ i+1;
        	
        	Address addr = new Address(i+1,stAddr,"DGK","Punjab","Pakistan");
        	addresses.add(addr);
        	
        	addressService.persist(addr);
        	//---------------------------------
        	
        	String fname = "first"+i+1;
        	String lname = "last"+i+1;
        	String email = fname+lname+"@globalrescue.com";
        	Contact c = new Contact(i+1,fname,lname,email,"Male","+923417889364",true,addresses.get(i),accounts.get(i));
        	contactService.persist(c);
        	
        }
        
    }
}
