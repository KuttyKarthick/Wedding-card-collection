package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Model.Supplier;
import com.niit.backend.dao.SupplierDAO;

@Controller
public class SupplierController {
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;

	@RequestMapping("/newSupplier")
	public String newSupplier(@ModelAttribute Supplier supplier, Model model) {
		boolean flag = supplierDAO.save(supplier);
		
		System.out.println(flag);
		model.addAttribute("isadminClickednewSupplier", true);
		return "redirect:/viewSupplier";
	}
	@RequestMapping("/addSupplier")
	public ModelAndView addSupplier(Model model)
	{
		ModelAndView mv=new ModelAndView("adminLogin");
		mv.addObject("isadminClickedaddSupplier",true);
		return mv;
	}
	@RequestMapping("/viewSupplier")
	public String viewSupplier(Model model)
	{
		List <Supplier> supplierList=supplierDAO.list();
		model.addAttribute("supplierList",supplierList);
		model.addAttribute("isadminClickedviewSupplier",true);
		return "adminLogin";
		}
	@RequestMapping("/editSupplier")
	public String editSupplier(@RequestParam("id")String id,Model model)
	{
		Supplier supplier=supplierDAO.get(id);
		model.addAttribute("supplier",supplier);
		model.addAttribute("isadminClickededitSupplier",true);
		return "adminLogin";
	}
	
	@RequestMapping("afterEditSupplier")
	public String afterEdit(@ModelAttribute Supplier supplier)
	{
		supplierDAO.update(supplier);
		return "redirect:/viewSupplier";
	}
	
	@RequestMapping("/searchSupplier")
	public ModelAndView orderedBy(@RequestParam(value="search") String search ) {
		
		List<Supplier> supplierList = supplierDAO.search(search);		 
		
		ModelAndView mv = new ModelAndView("adminLogin");
		
		mv.addObject("supplierList", supplierList);
		mv.addObject("isadminClickedviewSupplier", true);

		return mv;
		
	}
	
	@RequestMapping("/deleteSupplier")
	public String deleteSupplier(@RequestParam("id")String id)
	{
		supplierDAO.delete(id);
		return "redirect:/viewSupplier";
		}
	@ModelAttribute
	public void adminSupplier(Model model)
	{
		
		model.addAttribute("isLoggedInAdmin",true);
	}
	}
