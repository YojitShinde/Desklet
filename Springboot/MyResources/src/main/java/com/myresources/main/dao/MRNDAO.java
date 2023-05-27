package com.myresources.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myresources.main.pojo.MRNs;

@Repository
public class MRNDAO implements MRNDAOInterface{
	
	private int count;
	private static final String ADDMRN = "insert into mrn_master(po_number, supplier_name, supplier_city, product, product_qty) values(?,?,?,?,?)";
	private static final String GETMRNS = "select * from mrn_master";
	private static final String REMMRN = "delete from mrn_master where mrn_number = ?";
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public MRNDAO(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public boolean addMRN(MRNs mrn) {
		Object[] arg = { mrn.getPo_number(), mrn.getSupplier_name(), mrn.getSupplier_city(), mrn.getProduct(), mrn.getProduct_qty() };
		count = jdbctemplate.update(ADDMRN, arg);
		
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<MRNs> getMRNs() {
		try {
			List<MRNs> mrns = jdbctemplate.query(GETMRNS, new MRNRowMapper(jdbctemplate));
			return mrns;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean removeMRN(int mrn_number) {
		count = jdbctemplate.update(REMMRN, mrn_number);
		if (count < 0)
			return true;
		return false;
	}

}
