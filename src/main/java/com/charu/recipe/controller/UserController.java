package com.charu.recipe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charu.recipe.dao.RecipeDao;
import com.charu.recipe.dao.UserDao;
import com.charu.recipe.entity.RecipeEntity;
import com.charu.recipe.entity.UserEntity;
import com.charu.recipe.entity.web.LogInWebEntity;
import com.mysql.jdbc.log.Log;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private @Autowired UserDao userDao;
	private @Autowired RecipeDao recipeDao;
	
	@RequestMapping("/index")
	public String home(Model model){
		model.addAttribute("message", "Home Page");
		return "index";
	}
	
	@RequestMapping("/myaccount")
	public String myaccount(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		Object o = request.getSession().getAttribute("usersession");
		if (o != null){
			UserEntity userEntity = (UserEntity) o;
			model.addAttribute("user", userEntity);
			
			List<RecipeEntity> recipeEntities = recipeDao.selectUserRecipes(userEntity);
			model.addAttribute("recipes", recipeEntities);
		}
		else{
			response.sendRedirect("/recipe/charu/user/SignIn");
		}
		return "myaccount";
	}
	
	@RequestMapping("/logout")
	public void logout(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.getSession().removeAttribute("usersession");
		response.sendRedirect("/recipe/charu/user/SignIn");	
	}
	
	
	@RequestMapping("/new")
	public String newuserform(Model model){
        model.addAttribute("command",new UserEntity());
		model.addAttribute("action","newform");
		return "signup";
	}
	
	@RequestMapping(value = "/newform", method = RequestMethod.POST)
	public String newuserprocessform(@ModelAttribute("command") @Valid UserEntity userEntity, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()){
			model.addAttribute("action","newform");
			return "signup";
		}
		
		userDao.create(userEntity);
		model.addAttribute("message","New user created");
		return "message";
	}
	
	@RequestMapping("/update-{id}")
	public String userupdateform(@PathVariable Long id, Model model) {
		UserEntity userEntity = userDao.get(id);
		model.addAttribute("command",userEntity);
		model.addAttribute("action","updateform");
		return "signup";
	}
	
	@RequestMapping(value = "/updateform", method = RequestMethod.POST)
	public String updateprocessform(@ModelAttribute UserEntity userEntity, Model model) {
		userDao.update(userEntity);
		model.addAttribute("message","User updated");
		return "message";
	}
	
	@RequestMapping("/delete-{id}")
	public String delete(@PathVariable Long id, Model model) {
		UserEntity userEntity = userDao.get(id);
		userDao.delete(userEntity);
		model.addAttribute("message","user deleted");
		return "message";
	}
	@RequestMapping(value = "/SignIn")
	public String newlogin(UserEntity userEntity,Model model){
		model.addAttribute("command",new UserEntity());
		return "signin";
	}
    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginprocess(@ModelAttribute("command") @Valid LogInWebEntity logInWebEntity, BindingResult bindingResult, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
    	if(bindingResult.hasErrors()){
    		return "signin";
    	}
    	
    	UserEntity userEntity = new UserEntity();
    	userEntity.setEmail(logInWebEntity.getEmail());
    	userEntity.setPassword(logInWebEntity.getPassword());
    	List<UserEntity> entities = userDao.getByCriteria(userEntity);
		if (entities.size() == 1){
			request.getSession().setAttribute("usersession", entities.get(0));
			response.sendRedirect("/recipe/charu/user/myaccount");
		}
		else{
			model.addAttribute("message", "Incorrect User Information");
		}
		return "message";
	}

}
