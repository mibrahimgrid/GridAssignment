package com.Assignment1Hibernate.Hibernate.Sample;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface DaoInterface <T>
{
	
	public void persist(T Entity);
	public void update(T Entity);
	public T findById(int id);
	public void delete(T Entity);
	public List<T> findAll();
	public void deleteAll();
}
