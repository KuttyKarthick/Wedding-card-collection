package com.niit.backend;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.Model.Cart;
import com.niit.backend.Model.Category;
import com.niit.backend.Model.Product;
import com.niit.backend.Model.Shippingaddress;
import com.niit.backend.Model.Supplier;
import com.niit.backend.Model.User;
import com.niit.backend.dao.CartDAO;
import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.ShippingaddressDAO;
import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.dao.UserDAO;

public class Usertestcase {
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDAO userDAO;
	static CategoryDAO categoryDAO;
	static SupplierDAO supplierDAO;
	static ProductDAO productDAO;
	static CartDAO cartDAO;
	static ShippingaddressDAO shippingaddressDAO;

	@Autowired
	static User user;
   static Category category;
   static Supplier supplier;
   static Product product;
   static Cart cart;
   static Shippingaddress shippingaddress;
	/*public Usertestcase() {
		initialize();
		createUsertestcase();
	}*/

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		userDAO = (UserDAO) context.getBean("UserDAO");
		user = (User) context.getBean("user");
        
		categoryDAO=(CategoryDAO) context.getBean("CategoryDAO");
        category =(Category) context.getBean("category");
        
        supplierDAO=(SupplierDAO) context.getBean("SupplierDAO");
        supplier =(Supplier) context.getBean("supplier");
        
        productDAO=(ProductDAO) context.getBean("ProductDAO");
        product =(Product) context.getBean("product");
        
        cartDAO=(CartDAO) context.getBean("CartDAO");
        cart =(Cart) context.getBean("cart");
        
        
        shippingaddressDAO=(ShippingaddressDAO) context.getBean("ShippingaddressDAO");
        shippingaddress =(Shippingaddress) context.getBean("shippingaddress");
	}

	@Test
	public void createUsertestcase() {
		user.setEnabled(true);
		user.setFirst_name("jothi");
		user.setLast_name("raj");
		user.setAddress("Coimbatore");
		user.setUser_name("jothiraj");
		user.setUser_password("pass@123");
		/*user.setReenter("pass@123");*/
		user.setZipcode("627007");
		user.setEmail("jothiraj34@gmail.com");
		user.setContact_no(12345678);
	
		category.setCategory_Id("001");
		category.setCategory_name("fruits");
		category.setCategory_Description("fresh");
		
		supplier.setId("1");
		supplier.setName("fruits stores");
		supplier.setEmail_id("fruitsstores@gmail.com");
		supplier.setAddress("madurai");
		supplier.setPhone_no("95869856987");
		
	
		product.setPname("Apple");
		product.setPrice(65);
		product.setDescription("kashmir apple");
		product.setStock(10);
		product.setCategory("hiii");
		product.setSupplier("hello");
	
		
		
		cart.setShippingId("1");
		cart.setEmail("jothiraj34@gmail.com");
		cart.setUserid("1");
		cart.setDays(7);
		cart.setPid("101");
		cart.setPname("Aachi");
		cart.setPrice(900);
		cart.setQuantity(7);
	    cart.setTotal(5600);
	    cart.setStatus('N');
	    cart.setTotal(25);
	    
	    
	    
	    shippingaddress.setShippingId("1");
	    shippingaddress.setUserid("1");
	    shippingaddress.setUser_name("jothiraj");
	    shippingaddress.setEmail("jothiraj34@gmail.com");
	    shippingaddress.setContact_no("95869856987");
	    shippingaddress.setAddress("madurai");
	    shippingaddress.setZipcode("627007");
		
		
		
		boolean flag = userDAO.saveOrUpdate(user);
		boolean flag1=categoryDAO.save(category);
		boolean flag11=categoryDAO.update(category);
		boolean flag2=supplierDAO.save(supplier);
		boolean flag21=supplierDAO.update(supplier);
		boolean flag31=productDAO.save(product);
		boolean flag3=productDAO.update(product);
		boolean flag4=cartDAO.saveOrUpdate(cart);
		boolean flag5=shippingaddressDAO.saveOrUpdate(shippingaddress);
		
		System.out.println(flag11);
		System.out.println(flag1);
		System.out.println(flag);
		System.out.println(flag2);
		System.out.println(flag21);
		System.out.println(flag3);
		System.out.println(flag31);
		System.out.println(flag4);
		System.out.println(flag5);
	

		assertEquals("createUsertestcase", true, flag11);
		assertEquals("createUsertestcase", true, flag1);
		assertEquals("createUsertestcase", true, flag);
		assertEquals("createUsertestcase", true, flag2);
		assertEquals("createUsertestcase", true, flag21);
		assertEquals("createUsertestcase", true, flag3);
		assertEquals("createUsertestcase", true, flag31);
		assertEquals("createUsertestcase", true, flag4);
		assertEquals("createUsertestcase",true,flag5);
		
		
	}

}
