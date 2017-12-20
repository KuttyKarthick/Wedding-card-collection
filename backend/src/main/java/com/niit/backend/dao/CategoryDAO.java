package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.Model.Category;

public interface CategoryDAO {
	public List<Category> list();

	public boolean save(Category category);

	public boolean update(Category category);

	public void delete(String category_Id);

	public Category get(String category_Id);

	public Category getCategoryByID(String category_Id);

	public List<Category> search(String search);
}
