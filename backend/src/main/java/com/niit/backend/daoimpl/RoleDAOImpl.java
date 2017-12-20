package com.niit.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.backend.Model.Role;

import com.niit.backend.dao.RoleDAO;

@Repository("RoleDAO")
@Transactional
public class RoleDAOImpl implements RoleDAO{
	@Autowired
	private SessionFactory sessionFactory;
		
		
		//write user defined constructor with one parameter i.e., sessionFactory
	
		public RoleDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory = sessionFactory;
		}

		public boolean saveOrUpdate(Role role) {
			try
			{
			sessionFactory.getCurrentSession().saveOrUpdate(role);
			}catch (Exception e) {
				//if any excpetion comes during execute of try block, catch will excute
				e.printStackTrace();
				return false;
			}
			return true;
		}
	
		public Role getById(String userid) {
			return 	(Role)  sessionFactory.getCurrentSession().get(Role.class, userid);
		}

		
		public Role delete(String userid) {
			return 	(Role)  sessionFactory.getCurrentSession().get(Role.class, null); 
		}
		

		
		public List<Role> list() {
			@SuppressWarnings ({"unchecked"})
			List <Role> listRole = (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listRole;
		}
	
		
		public Role getByEmail(String email) {
			String hql = "from Role where email ='"+ email +"'";
			org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Role> listRole = (List<Role>) query.list();
			
			if (listRole != null && !listRole.isEmpty()){
				return listRole.get(0);
			}
			return null;
		}


}
