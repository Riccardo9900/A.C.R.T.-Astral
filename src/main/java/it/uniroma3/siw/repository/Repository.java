package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.EntityManager;

public interface Repository<T> {

	public T findById(Long id);
	
	public void setEntityManager(EntityManager em);
	
	public T save(T entity);
	
	public List<T> findAll();
    
	public void delete(T t);
	
	public void deleteAll();
	
	public long count();
	
	public boolean existsById(Long id);
}
