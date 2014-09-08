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

import com.charu.recipe.dao.UserDao;
import com.charu.recipe.entity.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private @Autowired UserDao userDao;
	
	@RequestMapping("/new")
	public String newuserform(Model model){
        model.addAttribute("command",new UserEntity());
		model.addAttribute("action","newform");
		return "signup";
	}
	
	@RequestMapping(value = "/newform", method = RequestMethod.POST)
	public String newuserprocessform(@ModelAttribute UserEntity userEntity, Model model) {
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
	public String loginprocess(@ModelAttribute UserEntity userEntity, Model model, HttpServletRequest request){
    	List<UserEntity> entities = userDao.getByCriteria(userEntity);
		if (entities.size() == 1){
			request.getSession().setAttribute("usersession", entities.get(0));
			model.addAttribute("message", "User sucessfully Login");
		}
		else{
			model.addAttribute("message", "Incorrect User Information");
		}
		return "message";
	}

}
