package com.niit.backend.Model;

import javax.persistence.CascadeType;
/*import javax.persistence.CascadeType;*/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/*import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;*/
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity // to map the data base table
@Table(name = "user") // if the table name and domain class name is different
@Component // context.scan("com.niit") --will scan the pacakge and create
			// singlton instances
public class User {
	@Id
	@GeneratedValue
	private String userid;

	private String first_name;
	private String last_name;
	private String user_name;
	private String user_password;
	
	private String address;

	private String zipcode;
	private String email;
	private long contact_no;

	private boolean enabled;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private Role role;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact_no() {
		return contact_no;
	}

	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

}
