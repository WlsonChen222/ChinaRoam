package com.chinaroam.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.chinaroam.dao.IPrinterDao;
import com.chinaroam.model.Printer;

@Transactional
@Repository
public class PrinterJpaDao implements IPrinterDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Printer> queryAll() {
		String hql = "FROM Printer ORDER BY id";
		return (List<Printer>) entityManager.createQuery(hql).getResultList();
	}
	
	

	@Override
	public List<Printer> queryByReseller(Integer reseller_id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Printer find(Integer id) {
		return entityManager.find(Printer.class, id);
	}

	@Override
	public boolean add(Printer printer) {
		if(printer!=null) {
			entityManager.persist(printer);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Printer printer) {
		if(printer!=null) {
			Printer original = this.find(printer.getId());
			if(original!=null) {
				original.setEmail(printer.getEmail());
				original.setIpaddress(printer.getIpaddress());
				original.setName(printer.getName());
				original.setResellerId(printer.getResellerId());				
				entityManager.flush();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			Printer printer = this.find(id);
			if(printer!=null) {
				entityManager.remove(printer);
				return true;
			}		
		}
		return false;
	}

}
