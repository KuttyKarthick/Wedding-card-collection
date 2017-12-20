package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.Model.Category;
import com.niit.backend.dao.CategoryDAO;

@Controller
public class CategoryController 
{
	@Autowired CategoryDAO categoryDAO;
	@Autowired Category category;
@RequestMapping("/newCategory")
public String newCategory(@ModelAttribute Category category,Model model)
{
	boolean flag=categoryDAO.save(category);
	System.out.println(flag);
	model.addAttribute("isadminClickednewCategory",true);
	return "redirect:viewCategory";
}
@RequestMapping("/addCategory")
public String addCategory(Model model) {
	model.addAttribute("isadminClickedaddCategory", true);
  return "adminLogin";
 }
@RequestMapping("/viewCategory")
public String viewCategory(Model model)
{
	List<Category>categoryList=categoryDAO.list();
	model.addAttribute("categoryList",categoryList);
	model.addAttribute("isadminClickedviewCategory",true);
	return "adminLogin";
}

@RequestMapping("editCategory")
public String editCategory(@RequestParam("category_Id") String category_Id, Model model){
	
	Category category = categoryDAO.get(category_Id);
	model.addAttribute("category", category);
	model.addAttribute("isadminClickededitCategory", true);
	return "adminLogin";
}

@RequestMapping("afterEdit")
public String afterEdit(@ModelAttribute Category category){
	categoryDAO.update(category);
	return "redirect:viewCategory";
}
@RequestMapping("/deletecategory")
public String deletecategory(@RequestParam("category_Id") String category_Id)
{
	categoryDAO.delete(category_Id);
	return "redirect:/viewCategory";
	}
@RequestMapping("/searchCategory")
public ModelAndView orderedBy(@RequestParam(value="search") String search ) {
	
	List<Category> categoryList = categoryDAO.search(search);		 
	
	ModelAndView mv = new ModelAndView("adminLogin");
	
	mv.addObject("categoryList", categoryList);
	mv.addObject("isadminClickedviewCategory", true);

	return mv;
	
}

@ModelAttribute
public void adminCategory(Model model){
	 model.addAttribute("isLoggedInAdmin", true);
}
}