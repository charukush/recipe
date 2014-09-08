package com.charu.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

}
