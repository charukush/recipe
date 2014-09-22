package com.charu.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charu.recipe.dao.CategoryDao;
import com.charu.recipe.entity.CategoryEntity;
import com.charu.recipe.entity.web.CategoryWebEntity;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * Form to create category
	 * @param model
	 * @return
	 */
	@RequestMapping("/newcategory")
	public String createcategoryform(Model model) {
		List<CategoryEntity> categoryEntities = categoryDao.getAll();
		model.addAttribute("categories",categoryEntities);
		model.addAttribute("command",new CategoryWebEntity());
		return "category";
	}
	
	/**
	 * Category Submission form
	 * @param categoryEntity
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newcategorysubmit", method = RequestMethod.POST )
	public String categoryprocessform(@ModelAttribute CategoryWebEntity categoryWebEntity, Model model) {
		CategoryEntity parentEntity = categoryDao.get(categoryWebEntity.getParent());
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(categoryWebEntity.getName());
		categoryEntity.setParent(parentEntity);
		categoryDao.create(categoryEntity);
		model.addAttribute("message", "New category cretaed");
		return "message";
	}
	
	@RequestMapping(value = "/upadecategoryform", method = RequestMethod.POST)
	public String categoryupdateform(@ModelAttribute CategoryWebEntity categoryWebEntity, Model model) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(categoryWebEntity.getId());
		categoryEntity.setName(categoryWebEntity.getName());
		CategoryEntity parent = categoryDao.get(categoryWebEntity.getParent());
		categoryEntity.setParent(parent);
		categoryDao.update(categoryEntity);
		model.addAttribute("message", "Category Updated");
		return "message";
	}
	
	/**
	 * Category delete 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete-{id}")
	public String categorydelete(@PathVariable Long id, Model model) {
		CategoryEntity categoryEntity = categoryDao.get(id);
		categoryDao.delete(categoryEntity);
		model.addAttribute("message", "Category deleted");
		return "message";
	}
	
	/**
	 * Category Update
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit-{id}")
	public String categoryupdate(@PathVariable Long id, Model model) {
		CategoryEntity categoryEntity = categoryDao.get(id);
		List<CategoryEntity> categoryEntities = categoryDao.getAll();
		model.addAttribute("command",categoryEntity);
		model.addAttribute("categories",categoryEntities);
		model.addAttribute("action","upadecategoryform");
		return "category";
	}
	
}
