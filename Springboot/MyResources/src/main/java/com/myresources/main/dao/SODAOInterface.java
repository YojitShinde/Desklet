package com.myresources.main.dao;

import java.util.List;

import com.myresources.main.pojo.SOs;

public interface SODAOInterface {
	
	public boolean addSO(SOs so);
	
	public List<SOs> getSOs();
	
	public boolean removeSO(int so_number);
}
