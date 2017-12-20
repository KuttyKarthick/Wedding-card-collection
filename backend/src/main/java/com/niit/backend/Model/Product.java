package com.niit.backend.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="product")
@Component
public class Product {
	
	@Id
	@GeneratedValue
	private String pid;
	private String pname;
	private int price;
    private String description;
    private int stock;
    private String category;
    private String supplier;
    


public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getSupplier() {
	return supplier;
}
public void setSupplier(String supplier) {
	this.supplier = supplier;
}



}
