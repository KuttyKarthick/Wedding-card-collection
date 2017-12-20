package com.niit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.backend.Model.Product;
import com.niit.backend.Model.Role;
import com.niit.backend.Model.Shippingaddress;
import com.niit.backend.Model.User;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.RoleDAO;
import com.niit.backend.dao.ShippingaddressDAO;
import com.niit.backend.dao.UserDAO;

@Controller
public class UserController {
	@Autowired
	UserDAO userDAO;
	@Autowired
	User user;

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	Role role;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ShippingaddressDAO shippingaddressDAO;
	

	@RequestMapping("/newUser")
	public String newUser(@ModelAttribute User user, @ModelAttribute Shippingaddress shippingaddress, Model model) {

		user.setEnabled(true);

		role.setUser_name(user.getUser_name());
		role.setEmail(user.getEmail());
		role.setRoole("ROLE_USER");
		role.setUser_password(user.getUser_password());

		user.setRole(role);
		role.setUser(user);

		boolean flag = userDAO.saveOrUpdate(user);
		boolean flag1 = roleDAO.saveOrUpdate(role);

		System.out.println(flag);
		System.out.println(flag1);
		
		shippingaddress.setUserid(user.getUserid());
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		
		model.addAttribute("isUserClickedSignup", "true");
		return "Home";

	}

	@RequestMapping("/afterlogin")
	public String afterlogin(Principal p, Model model) {
		String email = p.getName();
		User user = userDAO.getByEmail(email);

		Role role1 = roleDAO.getByEmail(email);

		String role = role1.getRoole();
		
		System.out.println(role);
		
		if(role.equals("ROLE_ADMIN")){
			 model.addAttribute("isLoggedInAdmin", true);
			return "adminLogin";
		}
		else if(role.equals("ROLE_USER")){
			List<Product> productList=productDAO.list();
			model.addAttribute("productList", productList);
			
			model.addAttribute("isLoggedInUser", true);
			
			return "userLogin";
		}
		else{
			model.addAttribute("error", "Invalid username or password!");
			return "Login";
		}
	}
}
