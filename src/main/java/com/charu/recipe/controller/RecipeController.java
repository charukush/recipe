package com.charu.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charu.recipe.dao.RecipeDao;
import com.charu.recipe.entity.RecipeEntity;
import com.charu.recipe.entity.UserEntity;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	@Autowired
	private RecipeDao recipeDao;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/newrecipe")
	public String newrecipeform(Model model, HttpServletRequest request) {
		UserEntity userEntity = (UserEntity) request.getSession().getAttribute("usersession");
		model.addAttribute("userdisplay",userEntity);
		model.addAttribute("command", new RecipeEntity());
		model.addAttribute("action","newrecipeform");
		return "recipe";
		
	}
	/**
	 * 
	 * @param recipeEntity
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newrecipeform", method = RequestMethod.POST)
	public String newrecipeprocessform(@ModelAttribute RecipeEntity recipeEntity,Model model) {
		recipeDao.create(recipeEntity);
		model.addAttribute("message", "Recipe created");
		return "message";
	
	}
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/update-{idrecipe}")
	public String update(@PathVariable Long idrecipe, Model model) {
		RecipeEntity recipeEntity = recipeDao.get(idrecipe);
		model.addAttribute("command",recipeEntity);
		model.addAttribute("action","recipeupdatedform");
		return "recipe";
	}
	/**
	 * 
	 * @param recipeEntity
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/recipeupdatedform", method = RequestMethod.POST)
	public String recipeupdatedform(@ModelAttribute RecipeEntity recipeEntity,Model model) {
		recipeDao.update(recipeEntity);
		model.addAttribute("message", "Recipe has been updated");
		return "message";
	}
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delete-{idrecipe}")
	public String delete(@PathVariable Long idrecipe,Model model) {
		RecipeEntity recipeEntity = recipeDao.get(idrecipe);
		recipeDao.delete(recipeEntity);
		model.addAttribute("message","Recipe deleted");
		return "message";
	}
	@RequestMapping("/AllRecipes")
	public String diplayRecipes(Model model) {
		List<RecipeEntity> recipeEntities = recipeDao.selectAllRecipes();
		model.addAttribute("recipes",recipeEntities);
		return "display";
	}

}
