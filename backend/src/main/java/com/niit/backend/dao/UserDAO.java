package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.Model.User;

public interface UserDAO {
	

	

	
     public List<User> list();
	
	public User get(String user_name);
	
	public User getByEmail(String email);
	
	public User getById(String userid);
	
	public boolean saveOrUpdate(User user);
		
	public void delete(String userid);




	

}
