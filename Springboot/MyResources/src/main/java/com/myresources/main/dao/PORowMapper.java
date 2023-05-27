package com.myresources.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.myresources.main.pojo.POs;

public class PORowMapper implements RowMapper<POs>{

	public PORowMapper(JdbcTemplate jdbctemplate) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public POs mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		POs po = new POs();
		
		po.setPo_number(resultSet.getInt("po_number"));
		po.setPayment_mode(resultSet.getString("payment_mode"));
		po.setSupplier_name(resultSet.getString("supplier_name"));
		po.setSupplier_city(resultSet.getString("supplier_city"));
		po.setSupplier_email(resultSet.getString("supplier_email"));
		po.setSupplier_phone(resultSet.getString("supplier_phone"));
		po.setProduct(resultSet.getString("product"));
		po.setProduct_qty(resultSet.getString("product_qty"));
		po.setUnit_price(resultSet.getString("unit_price"));
		po.setDate(resultSet.getString("date"));
		po.setTotal_price(resultSet.getInt("total_price"));
		
		return po;
	}

}
