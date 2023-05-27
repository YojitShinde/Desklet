package com.myresources.main.pojo;

import org.springframework.stereotype.Component;

@Component
public class Users {
	
	private String email_id;
	private String password;
	private String name;
	private String phone;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String email_id, String password, String name, String phone) {
		super();
		this.email_id = email_id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Users [email_id=" + email_id + ", password=" + password + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
