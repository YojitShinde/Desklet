package com.myresources.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.myresources.main.pojo.MRNs;

public class MRNRowMapper implements RowMapper<MRNs>{
	
	public MRNRowMapper(JdbcTemplate jdbctemplate) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MRNs mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		MRNs mrn = new MRNs();
		
		mrn.setMrn_number(resultSet.getInt("mrn_number"));
		mrn.setPo_number(resultSet.getInt("po_number"));
		mrn.setSupplier_name(resultSet.getString("supplier_name"));
		mrn.setSupplier_city(resultSet.getString("supplier_city"));
		mrn.setProduct(resultSet.getString("product"));
		mrn.setProduct_qty(resultSet.getString("product_qty"));
		
		return mrn;
	}

}
