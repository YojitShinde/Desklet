package com.myresources.main.dao;

import java.util.List;

import com.myresources.main.pojo.Users;

public interface UsersDAOInterface {

	public boolean addUser(Users user);
	
	public boolean removeUser(String email_id);
	
	public Users getUser(Users user);	
	
	public List<Users> getAllUsers();
}
