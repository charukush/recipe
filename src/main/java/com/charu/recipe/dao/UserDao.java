package com.charu.recipe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charu.recipe.entity.UserEntity;

@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;

/**
 * 
 * @param userEntity
 * @return
 */
	@Transactional
	public Long create(UserEntity userEntity){
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(userEntity);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public UserEntity get(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (UserEntity) session.get(UserEntity.class, id);
	}
	/**
	 * 
	 * @param userEntity
	 * @return
	 */
	@Transactional
	public UserEntity update(UserEntity userEntity){
		Session session = sessionFactory.getCurrentSession();
		return (UserEntity) session.merge(userEntity);
	}
	/**
	 * 
	 * @param userEntity
	 */
	@Transactional
	public void delete(UserEntity userEntity){
		Session session = sessionFactory.getCurrentSession();
		session.delete(userEntity);
		
	}
	/**
	 * User Log In Code
	 * @param userEntity
	 * @return
	 */
	@Transactional
	public List<UserEntity> getByCriteria(UserEntity userEntity){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		if (userEntity.getEmail() != null){
			criteria.add(Expression.eq("email",userEntity.getEmail()));
		}
		if (userEntity.getPassword() != null){
			criteria.add(Expression.eq("password",userEntity.getPassword()));
		}
		return (List<UserEntity>) criteria.list();
	}
	
}
