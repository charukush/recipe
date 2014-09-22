package com.charu.recipe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charu.recipe.dao.CategoryDao;
import com.charu.recipe.dao.RecipeDao;
import com.charu.recipe.entity.CategoryEntity;
import com.charu.recipe.entity.RecipeEntity;
import com.charu.recipe.entity.UserEntity;
import com.charu.recipe.entity.web.RecipeWebEntity;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/newrecipe")
	public String newrecipeform(Model model, HttpServletRequest request) {
		UserEntity userEntity = (UserEntity) request.getSession().getAttribute("usersession");
		List<CategoryEntity> categories = categoryDao.getAll();
		model.addAttribute("categorylist",categories);
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
	public String newrecipeprocessform(@ModelAttribute("command") @Valid RecipeWebEntity recipeWebEntity ,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			List<CategoryEntity> categories = categoryDao.getAll();
			model.addAttribute("categorylist",categories);
			model.addAttribute("action","newrecipeform");
            return "recipe";
        }
		
		//System.out.println(recipeWebEntity);
		RecipeEntity recipeEntity = new RecipeEntity();
		recipeEntity.setTitle(recipeWebEntity.getTitle());
		recipeEntity.setDisplaymsg(recipeWebEntity.getDisplaymsg());
		recipeEntity.setInstruction(recipeWebEntity.getInstruction());
		recipeEntity.setCookingtime(recipeWebEntity.getCookingtime());
		recipeEntity.setCuisine(recipeWebEntity.getCuisine());
		recipeEntity.setIngredients(recipeWebEntity.getIngredients());
		CategoryEntity categoryEntity = categoryDao.get(recipeWebEntity.getCookingcategory());
		recipeEntity.setCookingcategory(categoryEntity);
		//System.out.println(recipeEntity);
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
		List<CategoryEntity> categoryEntities = categoryDao.getAll();
		model.addAttribute("categorylist",categoryEntities);
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
	public String recipeupdatedform(@ModelAttribute RecipeWebEntity recipeWebEntity, Model model) {
		System.out.println(recipeWebEntity);
		RecipeEntity recipeEntity = new RecipeEntity();
		recipeEntity.setIdrecipe(recipeWebEntity.getIdrecipe());
		recipeEntity.setTitle(recipeWebEntity.getTitle());
		recipeEntity.setDisplaymsg(recipeWebEntity.getDisplaymsg());
		recipeEntity.setInstruction(recipeWebEntity.getInstruction());
		recipeEntity.setCookingtime(recipeWebEntity.getCookingtime());
		recipeEntity.setCuisine(recipeWebEntity.getCuisine());
		recipeEntity.setIngredients(recipeWebEntity.getIngredients());
		CategoryEntity categoryEntity = categoryDao.get(recipeWebEntity.getCookingcategory());
		recipeEntity.setCookingcategory(categoryEntity);
		//System.out.println(recipeEntity);
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
