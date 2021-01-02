package com.shop.ecomm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.ecomm.dao.UserDAO;
import com.shop.ecomm.entity.Address;
import com.shop.ecomm.entity.UserModelOne;
import com.shop.ecomm.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	HttpSession session;

	@GetMapping("/showCart")
	public ModelAndView showCart() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Shopping Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLines());
		return mv;
	}

	@GetMapping("/addcart")
	public String addCartLine(@RequestParam("productId") int productId) {
		String response = cartService.addCartLine(productId);
		return "redirect:/showCart?" + response;
	}

	@GetMapping("/{cartLineId}/update")
	public String udpateCartLine(@RequestParam int cartLineId, @RequestParam int count) {
		String response = cartService.manageCartLine(cartLineId, count);
		return "redirect:/cart/show?" + response;
	}

	@GetMapping("/removeItem")
	public String removeCartLine(@RequestParam int cartLineId) {
		String response = cartService.removeCartLine(cartLineId);
		return "redirect:/showCart?" + response;
	}

	@GetMapping("/validatecart")
	public String validateCart() {
		String response = cartService.validateCartLine();
		if (!response.equals("result=success")) {
			return "redirect:/showCart?" + response;
		} else {
			return "redirect:/cartcheckout";
		}
	}

	@GetMapping("/cartcheckout")
	public String showAddressConfirmation(Model model) {
		UserModelOne userModel = (UserModelOne) session.getAttribute("userModel");
		ArrayList<Address> addresses = new ArrayList<Address>();
		addresses.add(userDAO.getBillingAddress(userModel.getId()));
		model.addAttribute("addresses", addresses);
		Address shipping = new Address();
		model.addAttribute("shipping", shipping);
		return "order-address";
	}

}
