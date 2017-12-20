package com.niit.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.Model.Category;
import com.niit.backend.dao.CategoryDAO;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
     @Transactional
	public List<Category> list() {
		@SuppressWarnings({ "unchecked" })
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
	}

	public Category get(String category_Id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, category_Id);
	}

	public void delete(String category_Id) {
		Category categoryToDelete = new Category();
		categoryToDelete.setCategory_Id(category_Id);
		sessionFactory.getCurrentSession().delete(categoryToDelete);
	}

	public Category getCategoryByID(String category_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Category> search(String keyWord) {
		String hql = "from Category category where category_name like '%" + keyWord + "%' or category_Description like '%"+ keyWord + "%' or category_Id like '%" + keyWord + "%'";
		 
		//String hql = "SELECT * FROM Category WHERE id  LIKE " + keyWord + "% OR name LIKE " + keyWord + "% OR description LIKE " + keyWord + "%";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> categoryList = (List<Category>) (query).list();
		
		return categoryList;
	}

}
