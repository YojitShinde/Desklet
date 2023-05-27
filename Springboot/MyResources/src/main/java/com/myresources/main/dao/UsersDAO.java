package com.myresources.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresources.main.pojo.Users;

@Repository
public class UsersDAO implements UsersDAOInterface{
	
	private int count;
	private static final String ADDUSER = "insert into users_master(email_id, password, name, phone) values (?,?,?,?)";
	private static final String REMOVEUSER = "delete from users_master where email_id = ?";
	private static final String LOGIN = "select * from users_master where email_id = ? and password = ?";
	private static final String GETUSERS = "select * from users_master";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean addUser(Users user) {
		Object[] args = { user.getEmail_id(), user.getPassword(), user.getName(), user.getPhone() };
		count = jdbcTemplate.update(ADDUSER, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean removeUser(String email_id) {
		count = jdbcTemplate.update(REMOVEUSER, email_id);
		if (count < 0)
			return true;
		return false;
	}

	@Override
	public Users getUser(Users user) {
		Object[] args = { user.getEmail_id(), user.getPassword() };
		try {
			Users userObj = jdbcTemplate.queryForObject(LOGIN, new UsersRowMapper(jdbcTemplate), args);
			return userObj;
		}catch(Exception e) {
			return null;
		}
//		Users userObj = jdbcTemplate.queryForObject(LOGIN, new UsersRowMapper(jdbcTemplate), args);
//		if (userObj != null) {
//			System.out.println(userObj);
//			return userObj;
//		}
//		else {
//			System.out.println("null");
//			return null;
//		}
	}

	@Override
	public List<Users> getAllUsers() {
		try {
			List<Users> users = jdbcTemplate.query(GETUSERS, new UsersRowMapper(jdbcTemplate));
			return users;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

}
