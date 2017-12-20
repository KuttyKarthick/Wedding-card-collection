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
import com.niit.backend.Model.Product;
import com.niit.backend.Model.User;
import com.niit.backend.dao.CartDAO;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.ShippingaddressDAO;
import com.niit.backend.dao.UserDAO;

@Controller
public class CartController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	Cart cart;
	@Autowired
	Product product;
    
	@Autowired
	ShippingaddressDAO shippingaddressDAO; 
	
	

	@RequestMapping("myCart")
	public String mycart(Principal p, Model model) {
		List<Cart> cartList = cartDAO.getByEmailId(p.getName());
		Long totalcost = cartDAO.getTotal_amount(p.getName());

		model.addAttribute("total", totalcost);
		model.addAttribute("cartList", cartList);
		model.addAttribute("isUserClickedAddtocart", true);

		return "userLogin";
	} 

	@RequestMapping("addCart")
	public String addCart(@RequestParam(value = "pid") String id, Principal p, Model model) {

		Product product = productDAO.get(id);
		System.out.println(id);
		User user = userDAO.getByEmail(p.getName());
		System.out.println(user.getUserid());
		Cart crt = cartDAO.getbyUserandProduct(p.getName(), id);
		/*System.out.println(crt.getCart_id());
		System.out.println(crt.getQuantity());
		*/
		
		if (product.getStock() > 0) {

			if (cartDAO.itemAlreadyExist(p.getName(), id, true)) {
				System.out.println("haiiiii");
				int quantity = crt.getQuantity() + 1;
				crt.setQuantity(quantity);
				crt.setTotal(product.getPrice() *quantity);
				cartDAO.saveOrUpdate(crt);
			} else {

				cart.setPid(id);
				cart.setPname(product.getPname());
				cart.setEmail(p.getName());

				cart.setQuantity(1);
				cart.setPrice(product.getPrice());
				cart.setTotal(product.getPrice() * cart.getQuantity());
				cart.setUserid(user.getUserid());
				cart.setDays(1);
				cart.setTotal(cart.getTotal());
				cart.setStatus('N');

				cartDAO.saveOrUpdate(cart);
			}

			int quantity = product.getStock() - 1;
			product.setStock(quantity);

			productDAO.update(product);

			return "redirect:myCart";

		} else {
			System.out.println("helooooooooo");
			model.addAttribute("product", product);
			model.addAttribute("isUserClickedaddtocart", true);
			model.addAttribute("message", "Sorry the Product is Out of stock");
			return "userLogin";
		}
	}

	@RequestMapping("removeCart")
	public String removeCart(@RequestParam("cart_id") int id, Model model) {
		Cart cart = cartDAO.getByCartId(id);
		Product product = productDAO.get(cart.getPid());
		int quantity = product.getStock() + cart.getQuantity();
		product.setStock(quantity);
		productDAO.save(product);
		cartDAO.delete(id);
		return "redirect:myCart";
	}

	@ModelAttribute
	public void userCart(Model model) {
		model.addAttribute("isLoggedInUser", true);
	}
}
