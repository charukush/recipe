package com.charu.recipe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue
	private Long iduser;
	
	@NotEmpty(message = "Name should not be blank")
	@Column(name = "name")
	private String name;
	
	@NotEmpty(message = "Email should not be blank")
	@Column(name = "email")
	private String email;
	
	@NotEmpty(message = "Password should not be blank")
	@Column(name = "password")
	private String password;

	public UserEntity() {
		
	}

	public Long getId() {
		return iduser;
	}

	public void setId(Long id) {
		this.iduser = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + iduser + ", name=" + name + ", email=" + email
				+ ", password=" + password + "]";
	}
}
