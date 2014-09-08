package com.charu.recipe.entity.web;


public class CategoryWebEntity {
	
	private Long id;
	
	private String name;
	
	private Long parent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParent() {
		return parent;
	}

	public void setParent(Long parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "CategoryWebEntity [id=" + id + ", name=" + name + ", parent="
				+ parent + "]";
	}
}
