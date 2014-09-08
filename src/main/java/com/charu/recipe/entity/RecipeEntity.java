package com.charu.recipe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipe")
public class RecipeEntity {
	
	@Id
	@GeneratedValue
	private Long idrecipe;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "displaymsg")
	private String displaymsg;
	
	@Column(name = "instruction")
	private String instruction;
	
	@Column(name = "cookingtime")
	private String cookingtime;
	
	@Column(name = "cookingcategory")
	private String cookingcategory;
	
	@Column(name = "cuisine")
	private String cuisine;
	
	@Column(name = "ingredients")
	private String ingredients;

	public RecipeEntity() {
		
	}

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

	public String getCookingcategory() {
		return cookingcategory;
	}

	public void setCookingcategory(String cookingcategory) {
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
		return "RecipeEntity [idrecipe=" + idrecipe + ", title=" + title
				+ ", displaymsg=" + displaymsg + ", instruction=" + instruction
				+ ", cookingtime=" + cookingtime + ", cookingcategory="
				+ cookingcategory + ", cuisine=" + cuisine + ", ingredients="
				+ ingredients + "]";
	}
	
	

}
