package com.Assignment1Hibernate.Hibernate.Sample;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestAccountService 
{
	private static AccountService accountService;
	
	@BeforeClass
	public static void start()
	{
		accountService = new AccountService();
	}
	//test addressDao object
	@Test
	public void testAddressDaoObject() 
	{
		assertNotNull(accountService.accountDao());
	}
	//test persist method
	@Test
	public void testPersists()
	{
		Account account = new Account(20,"TestName","TestEmail","GMT+5");
		accountService.persist(account);
		Account getAccount = accountService.findById(account.getId());
		assertEquals(getAccount.getId(),account.getId());
	}
	
	@Test
	public void testFindById()
	{
		
		Account account = new Account(26,"TestName","TestEmail","GMT+5");
		accountService.persist(account);
		Account getAccount = accountService.findById(account.getId());
		assertEquals(account.getId(),getAccount.getId());
	}
	
	@Test
	public void testUpdate()
	{
		String updatedValue = "test@globalrescue.com";
		Account account = new Account(27,"TestName","TestEmail","GMT+5");
		accountService.persist(account);
		account.setEmail(updatedValue);
		accountService.update(account);
		Account getAccount = accountService.findById(account.getId());
		assertEquals(getAccount.getEmail(),account.getEmail());
	}
	@Test
	public void findAll()
	{
		List<Account> accounts = new ArrayList<Account>();
		for(int i=0; i<5; i++)
		{
			String name = "Acccount"+ i+1;
        	String mail = name+"@globalrescue.com";
        	String timezone = "GMT+5";
        	Account acc1 = new Account(i+1,name,mail,timezone);
        	accounts.add(acc1);
        	accountService.persist(acc1);
		}
		List<Account> getAccounts = accountService.findAll();
		
		for(int i=0; i<5; i++)
		{
			assertEquals(accounts.get(i).getId(),getAccounts.get(i).getId());
		}
	}
	@Test
	public void testDelete()
	{
		Account account = new Account(30,"TestName","Test@Email","GMT+5");
		accountService.persist(account);
		accountService.delete(account.getId());
		Account getAccount = accountService.findById(account.getId());
		assertNull(getAccount);
		
	}
	
	@Test
	public void testDeleteAll()
	{
		for(int i=15; i<20; i++)
		{
			Account acc = new Account(i+1,"TestName","Test@mail","GMT+5");
	    	accountService.persist(acc);
		}
		accountService.deleteAll();
		
		List<Account> accounts = accountService.findAll();
		
		assertEquals(accounts.size(),0);
	}

}
