package com.shop.ecomm.entity;

import java.util.List;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Component
public class UserModel {

	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String contactNumber;
	
	private String role;
	
	private String password;
	
	private String confirmPassword;
	
	private List<Address> adresslist;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Address> getAdresslist() {
		return adresslist;
	}

	public void setAdresslist(List<Address> adresslist) {
		this.adresslist = adresslist;
	}

		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

	@Override
	public String toString() {
		return "UserModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNumber="
				+ contactNumber + ", role=" + role + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", adresslist=" + adresslist + "]";
	}

	
	
	
	
}
