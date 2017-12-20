package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.Model.Cart;
import com.niit.backend.dao.CartDAO;

@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Cart cart) {
		try {
			Session session=sessionFactory.openSession();

			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		

		return true;

	}

	public List<Cart> list() {
		@SuppressWarnings({ "unchecked" })
		Session session=sessionFactory.openSession();

		List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.close();
		return listCart;
	}

	public Cart getByCartId(int id) {
		Session session=sessionFactory.openSession();

		String hql = "from Cart where cart_id ='" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) (query).list();

		if (listCart != null && !listCart.isEmpty()) {
			session.close();

			return listCart.get(0);
		}
		
		return null;

	}

	public Cart getByProductId(String pid) {
		Session session=sessionFactory.openSession();

		String hql = "from Cart where pid ='" + pid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) (query).list();

		if (listCart != null && !listCart.isEmpty()) {
			session.close();
            return listCart.get(0);
		}
		
		return null;
	}

	public List<Cart> getByEmailId(String email) {
		Session session=sessionFactory.openSession();

		String hql = "from Cart where email ='" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		session.close();

		return list;
	}

	public Long getTotal_amount(String email) {
		Session session=sessionFactory.openSession();

		String hql = "select sum(total) from Cart where email = " + "'" + email + "'" + "and status = '" + "N" + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Long sum = (Long) query.uniqueResult();
		session.close();
		return sum;
	}

	@Transactional
	public void delete(int cart_id) {
		Session session=sessionFactory.openSession();

		Cart cartToDelete = new Cart();
		cartToDelete.setCart_id(cart_id);
		sessionFactory.getCurrentSession().delete(cartToDelete);
		session.close();

	}

	@Transactional
	public Cart getbyUserandProduct(String email, String pid) {
		Session session=sessionFactory.openSession();

		String hql = "from Cart where email= '" + email + "' and " + " pid ='" + pid + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();

		if (listCart != null && !listCart.isEmpty()) {
			session.close();

			return listCart.get(0);
		}
		
		return null;
	}

	@Transactional
	public boolean itemAlreadyExist(String email, String id, boolean b) {
		Session session=sessionFactory.openSession();

		String hql = "from Cart where email= '" + email + "' and " + " pid ='" + id + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list != null && !list.isEmpty()) {
			session.close();

			return true;
		}
		
		return false;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Cart> list(int email) {
		Session session=sessionFactory.openSession();

		String hql = "from Cart where email=" + "'" + email + "'   and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		session.close();

		return list;
	}

	public List<Cart> search(String keyword) {
		Session session=sessionFactory.openSession();

		String hql = "from Cart p where p.userid like '%" + keyword + "%' or p.pname like '%" + keyword
				+ "%' or p.price like '%" + keyword + "%' or p.days like '%" + keyword + "%'";

		// String hql = "SELECT * FROM Category WHERE id LIKE " + keyWord + "%
		// OR name LIKE " + keyWord + "% OR description LIKE " + keyWord + "%";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> cartList = (List<Cart>) (query).list();
		session.close();

		return cartList;

	}

}
