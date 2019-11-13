package com.infosys.microservice1.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "customer")
public class Customer {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long customer_id;
	@NotEmpty(message = "Please provide a First Name")
	String firstname;
	@NotEmpty(message = "Please provide a Last Name")
	String lastname;
	@NotEmpty(message = "email must not be empty")
	@Email(message = "email should be a valid email")
	String emailid;
	
	@Digits(message="Only Numbers Are Allowed", fraction = 0, integer = 10)
	
	long phonenumber;  
	@JsonFormat(pattern = "dd/MM/yyyy")
	Date dob;
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", emailid=" + emailid + ", phonenumber=" + phonenumber + ", dob=" + dob + "]";
	}
	
}
