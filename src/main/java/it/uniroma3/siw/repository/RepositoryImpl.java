package it.uniroma3.siw.repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepositoryImpl<T> implements Repository<T> {

	private static final Logger logger = LogManager.getLogger();
	
	private EntityManager em;
	private Class<T> domainClass;

	public RepositoryImpl(Class<T> domainClass) {
		this.domainClass = domainClass;
	}

	@Override
	public T findById(Long id) {
		return em.find(this.domainClass, id);
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;		
		logger.debug("entityManager" + this.domainClass.getName() + "settato!");
	}

	@Override
	public T save(T entity) {		
		T persistentEntity = entity;
		Method getId = null;

		try {
			getId = this.domainClass.getMethod("getId");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}
		try {
			if ( getId.invoke(persistentEntity) != null ) {
				em.merge(persistentEntity);
				logger.debug("entità di" + this.domainClass.getName() + "modificata e salvata correttamente");
			}
			else {
				em.persist(persistentEntity);
				logger.debug("entità di" + this.domainClass.getName() + "salvata correttamente");
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return persistentEntity;
	}

	@Override
	public List<T> findAll() {
		return em.createQuery("select o from" + this.domainClass.getName() + "o", this.domainClass).getResultList();
	}

	@Override
	public void delete(T t) {
		this.em.remove(t);
		logger.debug("entità di" + this.domainClass.getName() + "rimossa");
	}

	@Override
	public void deleteAll() {
		this.em.createQuery("DELETE FROM" + this.domainClass.getName()).executeUpdate();
		logger.debug("tutte le entità di" + this.domainClass.getName() + "sono state eliminate!");
	}

	@Override
	public long count() {
		return (long)this.em.createQuery("SELECT COUNT(id) FROM" + this.domainClass.getName()).getSingleResult();
	}

	@Override
	public boolean existsById(Long id) {
		return this.findById(id)!=null;
	}

}
