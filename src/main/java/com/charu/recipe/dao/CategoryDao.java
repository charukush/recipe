package com.charu.recipe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charu.recipe.entity.CategoryEntity;

@Repository
public class CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Method to create category
	 * @param categoryEntity
	 * @return - category id which is created in database 
	 */
	@Transactional
    public Long create(CategoryEntity categoryEntity) {
    	Session session = sessionFactory.getCurrentSession();
    	return (Long) session.save(categoryEntity);
	}
	
	/**
	 * Method to list all categories
	 * @return
	 */
	@Transactional
	public List<CategoryEntity> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(CategoryEntity.class);
		List<CategoryEntity> categoryEntities =  criteria.list();
		return categoryEntities;
	}
	/**
	 * Method to get id
	 * @param id
	 * @return
	 */
	@Transactional
	public CategoryEntity get(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (CategoryEntity) session.get(CategoryEntity.class, id);
	}
	/**
	 * Method to delete category
	 * @param categoryEntity
	 */
	
	@Transactional
	public void delete(CategoryEntity categoryEntity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(categoryEntity);
	}
	/**
	 * Method to update Category
	 * @param categoryEntity
	 * @return
	 */
	@Transactional
	public CategoryEntity update(CategoryEntity categoryEntity) {
		Session session = sessionFactory.getCurrentSession();
		return (CategoryEntity) session.merge(categoryEntity);
	}
}
