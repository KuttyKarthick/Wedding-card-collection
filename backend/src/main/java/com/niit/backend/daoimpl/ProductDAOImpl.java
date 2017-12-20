package com.niit.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.backend.Model.Product;
import com.niit.backend.dao.ProductDAO;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;
		
		
		//write user defined constructor with one parameter i.e., sessionFactory
		
		public ProductDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory = sessionFactory;
		}

		
		public boolean save(Product product) {
			try
			{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			}catch (Exception e) {
				//if any excpetion comes during execute of try block, catch will excute
				e.printStackTrace();
				return false;
			}
			return true;
		}
			
		
		public boolean update(Product product) {
			try
			{
			sessionFactory.getCurrentSession().update(product);
			}catch (Exception e) {
				//if any excpetion comes during execute of try block, catch will excute
				e.printStackTrace();
				return false;
			}
			return true;
		}

		@Transactional
		public List<Product> list() {
			@SuppressWarnings({ "unchecked" })
			List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listProduct;
		}
		public Product get(String id) {

			String hql = "from Product where pid ='" + id + "'";
			Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Product> listProduct = (List<Product>) (query).list();

			if (listProduct != null && !listProduct.isEmpty()) {
				return listProduct.get(0);
			}
			return null;
		}
		
	
		public void delete(String pid) 
		{
			Product productToDelete=new Product();
			productToDelete.setPid(pid);
			sessionFactory.getCurrentSession().delete(productToDelete);
		}


		public List<Product> search(String keyword) {
			String hql = "from Product product where product.pname like '%" + keyword + "%' or product.description like '%"+ keyword + "%' or product.pid like '%" + keyword + "%'";
			 
			//String hql = "SELECT * FROM Category WHERE id  LIKE " + keyWord + "% OR name LIKE " + keyWord + "% OR description LIKE " + keyWord + "%";
			Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Product> productList = (List<Product>) (query).list();
			
			return productList;
		
		}

}
