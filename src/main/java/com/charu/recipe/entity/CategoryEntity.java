package com.charu.recipe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn
	private CategoryEntity parent;

	public CategoryEntity() {
		
	}
	
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

	public CategoryEntity getParent() {
		return parent;
	}

	public void setParent(CategoryEntity parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", name=" + name + ", parent="
				+ parent + "]";
	}

	
	
}
