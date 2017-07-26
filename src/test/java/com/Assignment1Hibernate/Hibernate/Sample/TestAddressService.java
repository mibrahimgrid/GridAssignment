
package com.Assignment1Hibernate.Hibernate.Sample;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestAddressService
{
	private static AddressService addressService;
	
	@BeforeClass
	public static void start()
	{
		addressService = new AddressService();
	}
	//test addressDao object
	@Test
	public void testAddressDaoObject() 
	{
		assertNotNull(addressService.addressDao());
	}
	//test persist method
	@Test
	public void testPersists()
	{
		Address address = new Address(20,"TestAdddress","TestCity","TestProvince","TestCountery");
		addressService.persist(address);
		Address getAddr = addressService.findById(address.getId());
		assertEquals(getAddr.getId(),address.getId());
	}
	
	@Test
	public void testFindById()
	{
		
		Address address = new Address(26,"TestAdddress","TestCity","TestProvince","TestCountry");
		addressService.persist(address);
		Address getAddr  = addressService.findById(address.getId());
		assertEquals(address.getId(),getAddr.getId());
	}
	
	@Test
	public void testUpdate()
	{
		String updatedValue = "Pakistan";
		Address address = new Address(27,"TestAdddress","TestCity","TestProvince","TestCountry");
		addressService.persist(address);
		address.setCountry(updatedValue);
		addressService.update(address);
		Address getAddr = addressService.findById(address.getId());
		assertEquals(getAddr.getCountry(),address.getCountry());
	}
	@Test
	public void findAll()
	{
		List<Address> addresses = new ArrayList<Address>();
		for(int i=0; i<5; i++)
		{
			String stAddr = "address"+ i+1;
	    	
	    	Address addr = new Address(i+1,stAddr,"DGK","Punjab","Pakistan");
	    	addresses.add(addr);
	    	
	    	addressService.persist(addr);
		}
		List<Address> getAddresses = addressService.findAll();
		
		for(int i=0; i<5; i++)
		{
			assertEquals(addresses.get(i).getId(),getAddresses.get(i).getId());
		}
	}
	@Test
	public void testDelete()
	{
		Address address = new Address(30,"TestAdddress","TestCity","TestProvince","TestCountry");
		addressService.persist(address);
		addressService.delete(address.getId());
		Address getAddr = addressService.findById(address.getId());
		assertNull(getAddr);
		
	}
	
	@Test
	public void testDeleteAll()
	{
		for(int i=15; i<20; i++)
		{
			String stAddr = "address"+ i+1;
	    	
	    	Address addr = new Address(i+1,stAddr,"DGK","Punjab","Pakistan");
	    	addressService.persist(addr);
		}
		addressService.deleteAll();
		
		List<Address> addresses = addressService.findAll();
		
		assertEquals(addresses.size(),0);
	}
}
