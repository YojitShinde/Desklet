package com.myresources.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.myresources.main.pojo.Users;

public class UsersRowMapper implements RowMapper<Users>{
	
	public UsersRowMapper(JdbcTemplate jdbctemplate) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Users mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Users user = new Users();
		
		user.setEmail_id(resultSet.getString("email_id"));
		user.setPassword(resultSet.getString("password"));
		user.setName(resultSet.getString("name"));
		user.setPhone(resultSet.getString("phone"));
		
		return user;
	}

}
