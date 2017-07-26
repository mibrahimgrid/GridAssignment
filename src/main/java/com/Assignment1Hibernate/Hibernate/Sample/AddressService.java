package com.Assignment1Hibernate.Hibernate.Sample;

import java.util.List;


public class AddressService 
{
	private static AddressDao addressDao;

	public AddressService() {
		addressDao = new AddressDao();
	}

	public void persist(Address entity) {
		addressDao.openCurrentSessionwithTransaction();
		addressDao.persist(entity);
		addressDao.closeCurrentSessionwithTransaction();
	}

	public void update(Address entity) {
		addressDao.openCurrentSessionwithTransaction();
		addressDao.update(entity);
		addressDao.closeCurrentSessionwithTransaction();
	}

	public Address findById(int id) {
		addressDao.openCurrentSession();
		Address address = addressDao.findById(id);
		addressDao.closeCurrentSession();
		return address;
	}

	public void delete(int id) {
		addressDao.openCurrentSessionwithTransaction();
		Address address = addressDao.findById(id);
		addressDao.delete(address);
		addressDao.closeCurrentSessionwithTransaction();
	}

	public List<Address> findAll() {
		addressDao.openCurrentSession();
		List<Address> addresses = addressDao.findAll();
		addressDao.closeCurrentSession();
		return addresses;
	}

	public void deleteAll() {
		addressDao.openCurrentSessionwithTransaction();
		addressDao.deleteAll();
		addressDao.closeCurrentSessionwithTransaction();
	}

	public AddressDao addressDao() {
		return addressDao;
	}

}