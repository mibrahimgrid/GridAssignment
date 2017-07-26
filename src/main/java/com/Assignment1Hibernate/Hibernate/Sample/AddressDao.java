package com.Assignment1Hibernate.Hibernate.Sample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AddressDao implements DaoInterface<Address>
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
	public void persist(Address entity) 
	{
		getCurrentSession().save(entity);
	}
	public void update(Address entity)
	{
		getCurrentSession().update(entity);
	}
	public Address findById(int id) 
	{
		Address address = (Address) getCurrentSession().get(Address.class, id);
		return address;
	}
	public void delete(Address entity)
	{
		getCurrentSession().delete(entity);
	}
	@SuppressWarnings("unchecked")
	public List<Address> findAll() 
	{
		List<Address> addresses = (List<Address>) getCurrentSession().createQuery("from Address").list();
		return addresses;
	}
	public void deleteAll() 
	{
		List<Address> entityList = findAll();
		for (Address entity : entityList) 
		{
			delete(entity);
		}
	}
	public void deleteById()
	{
		
	}

}
