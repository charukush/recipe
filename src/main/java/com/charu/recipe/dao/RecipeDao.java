package com.charu.recipe.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charu.recipe.entity.RecipeEntity;

@Repository
public class RecipeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Create Recipe method
	 * @param recipeEntity
	 * @return
	 */
	@Transactional
	public Long create(RecipeEntity recipeEntity) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(recipeEntity);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public RecipeEntity get(Long idrecipe) {
		Session session = sessionFactory.getCurrentSession();
		return (RecipeEntity) session.get(RecipeEntity.class, idrecipe);
	}
	/**
	 * 
	 * @param recipeEntity
	 * @return
	 */
	@Transactional
	public RecipeEntity update(RecipeEntity recipeEntity) {
		Session session = sessionFactory.getCurrentSession();
		return (RecipeEntity) session.merge(recipeEntity);
	}
	/**
	 * 
	 * @param recipeEntity
	 */
	@Transactional
	public void delete(RecipeEntity recipeEntity){
		Session session = sessionFactory.getCurrentSession();
		session.delete(recipeEntity);
	}
	
	/**
	 * Method to display all recipes 
	 * @return
	 */
	@Transactional
	public List<RecipeEntity> selectAllRecipes(){
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(RecipeEntity.class);
		List<RecipeEntity> recipeEntities = (List<RecipeEntity>) criteria.list();
		return recipeEntities;
	}
	

}
