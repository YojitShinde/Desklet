package com.myresources.main.dao;

import java.util.List;

import com.myresources.main.pojo.POs;

public interface PODAOInterface {
	
	public boolean addPO(POs po);
	
	public List<POs> getPOs();
	
	public boolean removePO(int po_number);
	
	public POs getPO(int po_number);
}
