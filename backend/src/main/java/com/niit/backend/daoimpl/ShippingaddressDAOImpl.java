package com.niit.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.Model.Shippingaddress;
import com.niit.backend.dao.ShippingaddressDAO;

@Repository("ShippingaddressDAO")
public class ShippingaddressDAOImpl implements ShippingaddressDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ShippingaddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Shippingaddress> list() {
		@SuppressWarnings({ "unchecked" })
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) sessionFactory.getCurrentSession()
				.createCriteria(Shippingaddress.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listShippingaddress;
	}

	@Transactional
	public List<Shippingaddress> list(String email) {
		String hql = "from Shippingaddress where email ='" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> list = (List<Shippingaddress>) query.list();

		return list;
	}

	@Transactional
	public Shippingaddress getByaddress(String address) {
		String hql = "from Shippingaddress where ShippingAddress ='" + address + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}

	@Transactional
	public Shippingaddress getByshippingId(String shippingId) {
		String hql = "from Shippingaddress where shippingId='" + shippingId + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}

	@Transactional
	public Shippingaddress getByUserName(String user_name) {
		String hql = "from Shippingaddress where UserName='" + user_name + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}

	@Transactional
	public Shippingaddress getByUserId(String userid) {
		String hql = "from Shippingaddress where usersId='" + userid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shippingaddress> listShippingaddress = (List<Shippingaddress>) (query).list();

		if (listShippingaddress != null && !listShippingaddress.isEmpty()) {
			return listShippingaddress.get(0);
		}
		return null;
	}

	@Transactional
	public boolean saveOrUpdate(Shippingaddress address) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(address);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean save(Shippingaddress address)
	{
		try {
			sessionFactory.getCurrentSession().save(address);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean update (Shippingaddress address){
		try {
			sessionFactory.getCurrentSession().update(address);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Transactional
	public void delete(String shippingId) {
		Shippingaddress addressToDelete = new Shippingaddress();
		addressToDelete.setShippingId(shippingId);
		sessionFactory.getCurrentSession().delete(addressToDelete);
	}

}
