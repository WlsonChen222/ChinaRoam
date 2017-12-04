package com.chinaroam.service;

import java.util.List;

import com.chinaroam.model.Printer;
import com.chinaroam.service.throwable.ServiceException;

public interface IPrinterService {
	
	public List<Printer> queryAll(String access_token)throws ServiceException;
	
	public Printer find(Integer id)throws ServiceException;
	
	public List<Printer> queryNearby()throws ServiceException;
	
	public void add(Printer printer)throws ServiceException;
	
	public void update(Printer printer)throws ServiceException;	

	public void delete(Integer id)throws ServiceException;	
}
