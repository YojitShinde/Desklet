package com.myresources.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myresources.main.dao.UsersDAOInterface;
import com.myresources.main.pojo.Users;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")
public class UsersController {
	
	@Autowired
	UsersDAOInterface usersDAOInterface;
	
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public void addUser(@RequestBody Users user) {
		usersDAOInterface.addUser(user);
	}
	
	@RequestMapping(value = "removeUser", method = RequestMethod.POST)
	public void removeUser(@RequestBody String email_id) {
		usersDAOInterface.removeUser(email_id);
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Users getUser(@RequestBody Users user) {
		return usersDAOInterface.getUser(user);
	}
	
	@RequestMapping(value = "getUsers", method = RequestMethod.GET)
	public List<Users> getUsers(){
		List<Users> users = usersDAOInterface.getAllUsers();
		return users;
	}
	
}
