package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.backend.Model.Product;
import com.niit.backend.dao.ProductDAO;

@Controller
public class HomeController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	HttpSession session;

	// http://localhost:8080/groceronmart/
	@RequestMapping("/")
	public String gotoHome(Model model) {
		
		List<Product> productList=productDAO.list();
		model.addAttribute("productList", productList);
		model.addAttribute("message", "Thank you for carting");
		
		return "Home";
	}

	@RequestMapping("/LoginPage")
	public String LoginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");
		return "Home";
	}

	@RequestMapping("/RegistrationPage")
	public String RegistrationPage(Model model) {
		model.addAttribute("isUserClickedRegister", "true");
		return "Home";
	}
	@RequestMapping("Productdetails")
	public String productdetails(@RequestParam("pid") String pid, Model model) {

		Product product = productDAO.get(pid);
		model.addAttribute("isLoggedInUser", true);
		model.addAttribute("isUserClickedimage", true);
	
		model.addAttribute("product", product);
		return "Home";

	}
}
