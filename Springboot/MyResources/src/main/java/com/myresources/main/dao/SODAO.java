package com.myresources.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresources.main.pojo.SOs;

@Repository
public class SODAO implements SODAOInterface{
	
	private int count;
	private static final String ADDSO = "insert into so_master(customer_name, customer_email, customer_phone, product, product_qty, date, unit_price, total_price, customer_add) values(?,?,?,?,?,?,?,?,?)";
	private static final String GETSOS = "select * from so_master";
	private static final String REMSO = "delete from so_master where so_number = ?";
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public SODAO(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public boolean addSO(SOs so) {
		int total = getTotal(so.getProduct_qty(), so.getUnit_price());
		Object[] arg = { so.getCustomer_name(), so.getCustomer_email(), so.getCustomer_phone(), so.getProduct(), so.getProduct_qty(), so.getDate(), so.getUnit_price(), total, so.getCustomer_address() };
		count = jdbctemplate.update(ADDSO, arg);
		
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<SOs> getSOs() {
		try {
			List<SOs> sos = jdbctemplate.query(GETSOS, new SORowMapper(jdbctemplate));
			System.out.println(sos);
			return sos;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean removeSO(int so_number) {
		count = jdbctemplate.update(REMSO, so_number);
		if (count < 0)
			return true;
		return false;
	}
	
	public int getTotal(String product_qty, String unit_price) {
		int qty = Integer.parseInt(product_qty);
		int unit = Integer.parseInt(unit_price);
		int total = qty*unit;
		return total;
	}

}
