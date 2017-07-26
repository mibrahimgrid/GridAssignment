package com.Assignment1Hibernate.Hibernate.Sample;

import java.util.List;

public class ContactService 
{

	private static ContactDao contactDao;
	
	public ContactService()
	{
		contactDao = new ContactDao();
	}
	
	public void persist(Contact enetity)
	{
		contactDao.openCurrentSessionwithTransaction();
		contactDao.persist(enetity);
		contactDao.closeCurrentSessionwithTransaction();
		
	}
	public void update(Contact entity)
	{
		contactDao.openCurrentSessionwithTransaction();
		contactDao.update(entity);
		contactDao.closeCurrentSessionwithTransaction();
	}
	
	public Contact findById(int id)
	{
		contactDao.openCurrentSession();
		Contact contact = contactDao.findById(id);
		contactDao.closeCurrentSession();
		return contact;
		
	}
	public void delete(int id)
	{
		contactDao.openCurrentSessionwithTransaction();
		Contact contact = contactDao.findById(id);
		contactDao.delete(contact);
		contactDao.closeCurrentSessionwithTransaction();
	}
	public List<Contact> findAll()
	{
		contactDao.openCurrentSession();
		List<Contact> contacts = contactDao.findAll();
		contactDao.closeCurrentSession();
		return contacts;
	}
	public void deleteAll()
	{
		contactDao.openCurrentSessionwithTransaction();
		contactDao.deleteAll();
		contactDao.closeCurrentSessionwithTransaction();
	}
	public ContactDao contactDao()
	{
		return contactDao;
	}
}
