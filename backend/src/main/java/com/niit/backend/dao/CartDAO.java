package com.niit.backend.dao;

import java.util.List;



import com.niit.backend.Model.Cart;

public interface CartDAO
{
	public  boolean saveOrUpdate(Cart cart);
    public List<Cart>list();
    public Cart getByCartId(int cart_id);
    public Cart getByProductId(String pid);
    public  List<Cart> getByEmailId(String email);
    
    public Long getTotal_amount(String email);
    public void delete(int cart_id);
	public Cart getbyUserandProduct(String userid, String pid);
	public boolean itemAlreadyExist(String userid, String pid, boolean b);
	public List<Cart> list(int cart_id ) ;
	public List<Cart> search(String keyword);
}
