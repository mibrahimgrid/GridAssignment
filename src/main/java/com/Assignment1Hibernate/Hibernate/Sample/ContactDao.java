package com.Assignment1Hibernate.Hibernate.Sample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ContactDao implements DaoInterface<Contact>
{
	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession()
	{
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	public Session openCurrentSessionwithTransaction() 
	{
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	public void closeCurrentSession() 
	{
		currentSession.close();
	}
	public void closeCurrentSessionwithTransaction()
	{
		currentTransaction.commit();
		currentSession.close();
	}
	private static SessionFactory getSessionFactory() 
	{
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
		.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	public Session getCurrentSession() 
	{
		return currentSession;
	}
	public void setCurrentSession(Session currentSession)
	{
		this.currentSession = currentSession;
	}
	public Transaction getCurrentTransaction()
	{
		return currentTransaction;
	}
	public void setCurrentTransaction(Transaction currentTransaction) 
	{
		this.currentTransaction = currentTransaction;
	}
	public void persist(Contact entity)
	{
		getCurrentSession().save(entity);
	}
	public void update(Contact entity)
	{
		getCurrentSession().update(entity);
	}
	public Contact findById(int id) 
	{
		Contact contact = (Contact) getCurrentSession().get(Contact.class, id);
		return contact;
	}
	public void delete(Contact entity)
	{
		getCurrentSession().delete(entity);
	}
	@SuppressWarnings("unchecked")
	public List<Contact> findAll() 
	{
		List<Contact> contacts = (List<Contact>) getCurrentSession().createQuery("from Contact").list();
		return contacts;
	}
	public void deleteAll() 
	{
		List<Contact> entityList = findAll();
		for (Contact entity : entityList) 
		{
			delete(entity);
		}
	}
	

}
