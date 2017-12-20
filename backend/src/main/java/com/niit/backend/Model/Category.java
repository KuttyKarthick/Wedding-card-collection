package com.niit.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")
@Component
public class Category {
	@Id
	@GeneratedValue
	private String category_Id;
	private String category_name;
    private String category_Description;
 
public String getCategory_Id() {
	return category_Id;
}
public void setCategory_Id(String category_Id) {
	this.category_Id = category_Id;
}
public String getCategory_name() {
	return category_name;
}
public void setCategory_name(String category_name) {
	this.category_name = category_name;
}
public String getCategory_Description() {
	return category_Description;
}
public void setCategory_Description(String category_Description) {
	this.category_Description = category_Description;
}

}
