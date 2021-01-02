package com.shop.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.ecomm.dao.CartLineDAO;
import com.shop.ecomm.dao.UserDAO;
import com.shop.ecomm.entity.Cart;
import com.shop.ecomm.entity.CartLine;
import com.shop.ecomm.entity.User;
import com.shop.ecomm.entity.UserModelOne;
import com.shop.ecomm.model.CheckoutModel;

@Controller
public class PaymentAndConfirmationController {

	@Autowired
	HttpSession session;
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/redirectpayment")
	public String redirectPayment(Model model) {
		UserModelOne userModel = (UserModelOne) session.getAttribute("userModel");
		User user = userDAO.get(userModel.getId());
		Cart cart = userModel.getCart();
		int cartId = cart.getId();
		List<CartLine> cartLines = cartLineDAO.listAvailable(cartId);
		
		CheckoutModel checkoutModel = new CheckoutModel();
		checkoutModel.setCart(cart);
		checkoutModel.setCartLines(cartLines);
		checkoutModel.setCheckoutTotal(cart.getGrandTotal());
		checkoutModel.setShipping(null);
		checkoutModel.setUser(user);
		
		model.addAttribute("checkoutModel",checkoutModel);
		return "order-payment";
	}
}
