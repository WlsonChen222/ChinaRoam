package com.chinaroam.dao;

import java.util.List;

import com.chinaroam.model.Printer;

public interface IPrinterDao {
	
	public List<Printer> queryAll();
	
	public List<Printer> queryByReseller(Integer reseller_id);
	
	public Printer find(Integer id);
	
	public boolean add(Printer printer);
	
	public boolean update(Printer printer);
	
	public boolean delete(Integer id);

}
