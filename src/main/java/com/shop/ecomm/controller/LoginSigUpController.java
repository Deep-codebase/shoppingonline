package com.shop.ecomm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shop.ecomm.dao.UserDAO;
import com.shop.ecomm.entity.Address;
import com.shop.ecomm.entity.Cart;
import com.shop.ecomm.entity.User;
import com.shop.ecomm.entity.UserModel;

@Controller
public class LoginSigUpController {

	@Autowired
	private UserDAO userDAO;

	UserModel user = null;
	Address address = null;

	@GetMapping("/membership")
	public String showSignUpPage(Model model) {
		user = new UserModel();
		model.addAttribute("user", user);
		return "signup-personal";
	}

	@PostMapping("/submitPersonalDetails")
	public String submitPersonalDetails(@ModelAttribute("user") UserModel usermodel, Model model) {
		System.out.println("hit submitPersonalDetails method");
		System.out.println("usermodel: " + usermodel);
		user = usermodel;
		showBillingAdressesPage(usermodel, model);
		return "redirect:/showBillingPage";
	}

	@GetMapping("/showBillingPage")
	public String showBillingAdressesPage(UserModel usermodel, Model model) {
		System.out.println("hit showAdressesPage method");
		address = new Address();
		model.addAttribute("address", address);
		if (user.getAdresslist() == null) {
			user.setAdresslist(new ArrayList<Address>());
			user.getAdresslist().add(address);
		}

		System.out.println(user);
		return "signup-billing";
	}

	@PostMapping("/submitbillingadresses")
	public String submitBillingAdresses(@ModelAttribute("address") Address billingaddress, UserModel usermodel,
			Model model) {
		Address billadd = user.getAdresslist().get(0);
		billadd.setAddressLineOne(billingaddress.getAddressLineOne());
		billadd.setAddressLineTwo(billingaddress.getAddressLineTwo());
		billadd.setCity(billingaddress.getCity());
		billadd.setCountry(billingaddress.getCountry());
		billadd.setPostalCode(billingaddress.getPostalCode());
		billadd.setShipping(true);
		billadd.setBilling(true);
		billadd.setState(billingaddress.getState());
		showConfirmationPage(user, model);
		return "redirect:/showConfirmationPage";
	}

	@GetMapping("/showConfirmationPage")
	public String showConfirmationPage(UserModel usermodel, Model model) {
		model.addAttribute("usermodel", user);
		return "signup-confirm";
	}

	@GetMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") UserModel usermodel) {
		System.out.println("Saving user: " + user);
		User userentity = new User();
		userentity.setFirstName(user.getFirstName());
		userentity.setLastName(user.getLastName());
		userentity.setEmail(user.getEmail());
		userentity.setContactNumber(user.getContactNumber());
		userentity.setEnabled(true);
		userentity.setRole(user.getRole());
		userentity.setPassword(user.getPassword());
		userentity.setConfirmPassword(user.getConfirmPassword());

		if (user.getRole().equals("USER")) {
			// create a new cart
			Cart cart = new Cart();
			cart.setUser(userentity);
			userentity.setCart(cart);
		}

		userDAO.addUser(userentity);
		
		Address billing = user.getAdresslist().get(0);
		billing.setUserId(userentity.getId());
		billing.setBilling(true);
		userDAO.addAddress(billing);

		

		return "signup-success";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
}
