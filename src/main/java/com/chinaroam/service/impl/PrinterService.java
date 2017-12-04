package com.chinaroam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinaroam.dao.IPrinterDao;
import com.chinaroam.model.Printer;
import com.chinaroam.service.IPrinterService;
import com.chinaroam.service.throwable.ServiceException;


/**
 * https://www.concretepage.com/spring-boot/spring-boot-rest-jpa-hibernate-mysql-example
 * @author Wilson
 *
 */
@Service
public class PrinterService implements IPrinterService {

	@Autowired
	private IPrinterDao printerDao;

	
	@Override
	public List<Printer> queryAll(String access_token) throws ServiceException {
		return printerDao.queryAll();
	}

	@Override
	public Printer find(Integer id) throws ServiceException {
		return printerDao.find(id);
	}

	@Override
	public List<Printer> queryNearby() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Printer printer) throws ServiceException {
		printerDao.add(printer);
	}

	@Override
	public void update(Printer printer) throws ServiceException {
		printerDao.update(printer);
	}

	@Override
	public void delete(Integer id) throws ServiceException {
		// TODO Auto-generated method stub

	}

}
