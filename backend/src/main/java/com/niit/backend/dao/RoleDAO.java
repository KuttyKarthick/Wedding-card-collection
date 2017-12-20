package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.Model.Role;

public interface RoleDAO {

	public boolean saveOrUpdate(Role role);

	/*public boolean update(Role role);*/

	public List<Role> list();

	public Role getById(String userid);

	public Role getByEmail(String email);

	public Role delete(String username);

}
