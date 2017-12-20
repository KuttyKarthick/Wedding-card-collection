package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.backend.Model.Cart;
import com.niit.backend.Model.Shippingaddress;
import com.niit.backend.Model.User;
import com.niit.backend.dao.CartDAO;
import com.niit.backend.dao.ShippingaddressDAO;
import com.niit.backend.dao.UserDAO;

@Controller
public class ShippingController 
{
	@Autowired
	ShippingaddressDAO shippingaddressDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	UserDAO userDAO;

	@RequestMapping("addShipping")
	public String addShipping(Model model)
	{
		model.addAttribute("isUserClickedNewShiiping", true);
		return "userLogin";
		
	}
	@RequestMapping("proceed")
	public String Proceed(Principal p, Model model) {
		String email = p.getName();
		List<Shippingaddress> shippingList = shippingaddressDAO.list(email);
		model.addAttribute("shippingList", shippingList);
		model.addAttribute("isUserClickedShippingAddressClicked", true);
		return "userLogin";

	}
	
	@RequestMapping("address")
	public String Address(Principal p,@ModelAttribute Shippingaddress address, Model model) {
		address.setEmail(p.getName());
		shippingaddressDAO.save(address);
		//model.addAttribute("isUserClickedSend", true);
		return "redirect:proceed";
	}
	
	@RequestMapping("deleteshippingAddress")
	public String deleteshippingAddress(@RequestParam("shippingId") String shippingId, Model model) {
		shippingaddressDAO.delete(shippingId);
		return "redirect:proceed";

	}
	@RequestMapping("aftereditshipping")
	public String afteredit(@ModelAttribute Shippingaddress shippingaddress,Principal p)
	{
		User user=userDAO.getByEmail(p.getName());
		shippingaddress.setUserid(user.getUserid());
		shippingaddress.setEmail(p.getName());
		//shippingaddress.setUserid(user.getUserid());
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		return"redirect:proceed";
	}
	
	
	@RequestMapping("shippingAddress")
	public String shippingAddress(@RequestParam("shippingId") String shippingId, Principal p, Model model) {

		String email = p.getName();
                 System.out.println(email);
		List<Cart> cartList = cartDAO.getByEmailId(email);

		for (Cart c : cartList) {
			c.setShippingId(shippingId);
			c.setStatus('P');
			System.out.println(shippingId);
			cartDAO.saveOrUpdate(c);
		}
		model.addAttribute("isUserClickedDeliverHere", true);
		return "userLogin";

	}
	
	
	@RequestMapping("editshippingAddress")
	public String editshippingAddress(@RequestParam("shippingId") String shippingId,Model model){
	Shippingaddress address=	shippingaddressDAO.getByshippingId(shippingId);
	List<Shippingaddress> shippingList = shippingaddressDAO.list(shippingId);
	model.addAttribute("shippingList", shippingList);
	shippingaddressDAO.saveOrUpdate(address);
		model.addAttribute("Shippingaddress", address);
		model.addAttribute("isUserClickededitShippingAddress", true);
		return "userLogin";
	

}
	@RequestMapping("thankyou")
	public String endship(Model model){
		model.addAttribute("isuserclickedthankyou", true);
		
		return "userLogin";
	}
	
	
	@ModelAttribute
	public void userCart(Model model) {
		model.addAttribute("isLoggedInUser", true);
	}
}
