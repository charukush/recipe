package com.charu.recipe.entity.web;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RecipeWebEntity {
	
	private Long idrecipe;
	
	@Size(min=5, max=30, message="Title should be > 5 and < 30 characters in length.")
	private String title;
	
	@NotEmpty( message="Display message should not be blank")
	private String displaymsg;
	
	@NotEmpty(message = "Instruction should not be blank")
	private String instruction;
	
	@NotEmpty(message = "Cooking Time should not be blank")
	private String cookingtime;
	
	private Long cookingcategory;
    
	@NotEmpty(message = "Cuisine should not be blank")
    private String cuisine;
    
	@NotEmpty(message = "Ingredients should not be blank")
    private String ingredients;

	public Long getIdrecipe() {
		return idrecipe;
	}

	public void setIdrecipe(Long idrecipe) {
		this.idrecipe = idrecipe;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDisplaymsg() {
		return displaymsg;
	}

	public void setDisplaymsg(String displaymsg) {
		this.displaymsg = displaymsg;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getCookingtime() {
		return cookingtime;
	}

	public void setCookingtime(String cookingtime) {
		this.cookingtime = cookingtime;
	}

	public Long getCookingcategory() {
		return cookingcategory;
	}

	public void setCookingcategory(Long cookingcategory) {
		this.cookingcategory = cookingcategory;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "RecipeWebEntity [idrecipe=" + idrecipe + ", title=" + title
				+ ", displaymsg=" + displaymsg + ", instruction=" + instruction
				+ ", cookingtime=" + cookingtime + ", cookingcategory="
				+ cookingcategory + ", cuisine=" + cuisine + ", ingredients="
				+ ingredients + "]";
	}
    
    

}
