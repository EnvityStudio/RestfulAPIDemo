package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.entity.User;


@Transactional
@Repository
public class UserDAOImp implements UserDAO {	
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public User login(String name, String password) {
		String sql = "SELECT  u  from User u  WHERE u.name= '"+name+"'and u.password= '"+password+"'";
		Query query = (Query) getEntityManager().createQuery(sql);
		
		System.out.println("sql"+sql);
		
		return (User) query.getSingleResult();
	}

}
