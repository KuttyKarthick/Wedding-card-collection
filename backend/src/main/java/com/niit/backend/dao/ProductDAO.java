package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.Model.Product;

public interface ProductDAO {
	public  boolean save(Product product);
	public boolean update(Product product);
	
	public Product get(String id);
	
	public void delete(String pid);
	public List<Product>     list();
	public List<Product> search(String keyword);

}
