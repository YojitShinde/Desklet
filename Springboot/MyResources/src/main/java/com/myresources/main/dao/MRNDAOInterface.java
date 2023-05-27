package com.myresources.main.dao;

import java.util.List;

import com.myresources.main.pojo.MRNs;


public interface MRNDAOInterface {

	public boolean addMRN(MRNs mrn);
	
	public List<MRNs> getMRNs();
	
	public boolean removeMRN(int mrn_number);
}
