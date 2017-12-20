package com.niit.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Cart")
@Component
public class Cart {
	
	@Id
	@GeneratedValue
	private int cart_id;
	private String shippingId;

private String userid;
private String email;
private String pname;
private String pid;
private int price;

private int  quantity;
private char status;
private int days;
private int total;





	
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getCart_id() {
	return cart_id;
}
public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}
public int getDays() {
	return days;
}
public void setDays(int days) {
	this.days = days;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public String getShippingId() {
	return shippingId;
}
public void setShippingId(String shippingId) {
	this.shippingId = shippingId;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}


}
