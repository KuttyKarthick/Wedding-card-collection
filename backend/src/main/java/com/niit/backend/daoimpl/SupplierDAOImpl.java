package com.niit.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.backend.Model.Supplier;
import com.niit.backend.dao.SupplierDAO;

@Repository("SupplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	private SessionFactory sessionFactory;

	// write user defined constructor with one parameter i.e., sessionFactory

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
		public boolean update(Supplier supplier) {
			try {
				sessionFactory.getCurrentSession().update(supplier);
			} catch (Exception e) {
				// if any excpetion comes during execute of try block, catch will
				// excute
				e.printStackTrace();
				return false;
			}
			return true;

}
	
	@Transactional
	public List<Supplier> list() {

		@SuppressWarnings({ "unchecked" })
		List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listSupplier;
	}

	public Supplier get(String id) {

		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);

	}
	public void delete(String id) {
		Supplier supplierToDelete = new Supplier();
		supplierToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(supplierToDelete);
		
	}
	public List<Supplier> search(String keyword) {
		
		String hql = "from Supplier supplier where supplier.name like '%" + keyword + "%' or supplier.email_id like '%"+ keyword + "%' or supplier.id like '%" + keyword + "%'";
		 
		//String hql = "SELECT * FROM Category WHERE id  LIKE " + keyWord + "% OR name LIKE " + keyWord + "% OR description LIKE " + keyWord + "%";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList = (List<Supplier>) (query).list();
		
		return supplierList;
	}

	
	

}
