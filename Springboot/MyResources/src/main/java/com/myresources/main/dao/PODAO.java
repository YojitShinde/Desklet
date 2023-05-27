package com.myresources.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresources.main.pojo.POs;

@Repository
public class PODAO implements PODAOInterface{

	private int count;
	private static final String ADDPO = "insert into po_master(payment_mode, supplier_name, supplier_city, supplier_email, supplier_phone, product, product_qty, unit_price, date, total_price) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String GETPOS = "select * from po_master";
	private static final String REMPO = "delete from po_master where po_number = ?";
	private static final String GETPO = "select * from po_master where po_number = ?";
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public PODAO(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}
	
	@Override
	public boolean addPO(POs po) {
		int total = getTotal(po.getProduct_qty(), po.getUnit_price());
		Object[] arg = { po.getPayment_mode(), po.getSupplier_name(), po.getSupplier_city(), po.getSupplier_email(), po.getSupplier_phone(), po.getProduct(), po.getProduct_qty(), po.getUnit_price(), po.getDate(), total };
		count = jdbctemplate.update(ADDPO, arg);
		
		if (count > 0) {
			return true;
		}
		return false;
		
	}

	@Override
	public List<POs> getPOs() {
		try {
			List<POs> pos = jdbctemplate.query(GETPOS, new PORowMapper(jdbctemplate));
			return pos;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean removePO(int po_number) {
		count = jdbctemplate.update(REMPO, po_number);
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

	@Override
	public POs getPO(int po_number) {
		POs po = jdbctemplate.queryForObject(GETPO, new PORowMapper(jdbctemplate), po_number);
		return po;
	}
}
