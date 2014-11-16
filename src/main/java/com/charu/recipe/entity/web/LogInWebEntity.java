package com.charu.recipe.entity.web;

import org.hibernate.validator.constraints.NotEmpty;

public class LogInWebEntity {
	
	private Long iduser;
	@NotEmpty( message="Email should not be blank")
	private String email;
	
	@NotEmpty(message = "Password should not be blank")
	private String password;

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
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
		return "LogInWebEntity [iduser=" + iduser + ", email=" + email
				+ ", password=" + password + "]";
	}

	
	
	

}
