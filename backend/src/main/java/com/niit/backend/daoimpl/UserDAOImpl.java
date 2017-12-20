package com.niit.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.Model.User;
import com.niit.backend.dao.UserDAO;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	// write user defined constructor with one parameter i.e., sessionFactory

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * This save method create record in the User table. If the record is
	 * created successfully, it will return true else will return false
	 */

	/*public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
*/
	/**
	 * This update method update record in the User table. If the record is
	 * updated successfully, it will return true else will return false
	 */
	/*public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;*/
	

	/**
	 * validate method will return true if the credetails are correct else will
	 * return false
	 */
	

	

	@SuppressWarnings("unchecked")
	public List<User> list() {

		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User get(String userid) {

		// get method get the date from user table based on primary key i.e., id
		// and set it to User class
		// like select * from user where id = ?
		return (User) sessionFactory.getCurrentSession().get(User.class, userid);

	}

	

	public User getByEmail(String email) {
		String hql = "from User where email ='"+ email +"'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) query.list();
		
		if (listUser != null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
	}

	public User getById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveOrUpdate(User user) {

		try {
			sessionFactory.getCurrentSession().save(user);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void delete(String userid) {
		// TODO Auto-generated method stub

	}

	
}
