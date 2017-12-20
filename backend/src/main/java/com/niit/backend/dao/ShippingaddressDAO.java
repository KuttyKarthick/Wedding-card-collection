package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.Model.Shippingaddress;

public interface ShippingaddressDAO
{
	 public List<Shippingaddress> list();
	    
	    public List<Shippingaddress> list(String email);
		
		public Shippingaddress getByaddress(String address);
		
		public Shippingaddress getByshippingId(String shippingId);
		
		public Shippingaddress getByUserName(String user_name);
		
		public Shippingaddress getByUserId(String userid);
		
		public boolean saveOrUpdate(Shippingaddress address);
		
		public boolean save(Shippingaddress address);
		
		public boolean update (Shippingaddress address);
		
		public void delete(String shippingId);
		
		

}
