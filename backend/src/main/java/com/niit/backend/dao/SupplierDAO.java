package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.Model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> list();

	public boolean save(Supplier supplier);

	public boolean update(Supplier supplier);
    
	public Supplier get(String id);
	public void delete(String id);

	public List<Supplier> search(String keyword);
}
