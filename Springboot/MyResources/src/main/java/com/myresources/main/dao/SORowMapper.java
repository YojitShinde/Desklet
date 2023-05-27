package com.myresources.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.myresources.main.pojo.SOs;

public class SORowMapper implements RowMapper<SOs>{
	
	public SORowMapper(JdbcTemplate jdbctemplate) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SOs mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		SOs so = new SOs();
		
		so.setSo_number(resultSet.getInt("so_number"));
		so.setCustomer_name(resultSet.getString("customer_name"));
		so.setCustomer_email(resultSet.getString("customer_email"));
		so.setCustomer_phone(resultSet.getString("customer_phone"));
		so.setProduct(resultSet.getString("product"));
		so.setProduct_qty(resultSet.getString("product_qty"));
		so.setDate(resultSet.getString("date"));
		so.setUnit_price(resultSet.getString("unit_price"));
		so.setTotal_price(resultSet.getInt("total_price"));
		so.setCustomer_address(resultSet.getString("customer_add"));
		
		return so;
	}

}
