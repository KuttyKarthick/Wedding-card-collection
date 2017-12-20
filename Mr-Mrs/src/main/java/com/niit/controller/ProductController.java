package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Model.Category;
import com.niit.backend.Model.Product;
import com.niit.backend.Model.Supplier;
import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.SupplierDAO;
import com.niit.util.FileUtil;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping("/newProduct")
	public String newProduct(@ModelAttribute Product product, @RequestParam("image")MultipartFile file, Model model) {
		boolean flag = productDAO.save(product);
		System.out.println(flag);
		String path="E:\\jothiraj\\Mr-Mrs\\src\\main\\webapp\\WEB-INF\\resources\\images\\Product";
		FileUtil.upload(path, file, product.getPid()+".jpg");
		model.addAttribute("isadminClickednewProduct", true);
		return "redirect:/viewProduct";

	}

	@RequestMapping("/addProduct")
	public String addProduct(Model model) {

		List<Category> categoryList = categoryDAO.list();
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("isAddProductClicked", true);
		
		return "adminLogin";
	}

	@RequestMapping("/viewProduct")
	public String viewProduct(Model model) {
		List<Product> productList = productDAO.list();
		model.addAttribute("productList", productList);
		model.addAttribute("isadminClickedviewProduct", true);
		return "adminLogin";
	}

	@RequestMapping("/editProduct")
	public String editProduct(@RequestParam("pid") String pid, Model model) {
		Product product = productDAO.get(pid);
		model.addAttribute("product", product);
		List<Category> categoryList = categoryDAO.list();
		List<Supplier> supplierList = supplierDAO.list();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("supplierList", supplierList);
		
		model.addAttribute("isadminClickededitProduct", true);
		return "adminLogin";
	}

	@RequestMapping("afterEditProduct")
	public String afterEdit(@ModelAttribute Product product){
		productDAO.update(product);
		
		return "redirect:/viewProduct";
	}
	
	@RequestMapping("/searchProduct")
	public ModelAndView orderedBy(@RequestParam(value="search") String search ) {
		
		List<Product> productList = productDAO.search(search);		 
		
		ModelAndView mv = new ModelAndView("adminLogin");
		
		mv.addObject("productList", productList);
		mv.addObject("isadminClickedviewProduct", true);

		return mv;
	}
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("pid") String pid) {
		productDAO.delete(pid);
		return "redirect:/viewProduct";
	}

	@ModelAttribute
	public void adminProduct(Model model) {
		model.addAttribute("isLoggedInAdmin", true);
	}
}
