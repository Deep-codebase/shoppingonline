package com.shop.ecomm.controller;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.ecomm.dao.UserDAO;
import com.shop.ecomm.entity.User;
import com.shop.ecomm.entity.UserDto;
import com.shop.ecomm.entity.UserModelOne;

@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private HttpSession session;
	
	private UserModelOne userModel = null;
	private User user = null;	
	
	
	@ModelAttribute("userModel")
	public UserModelOne getUserModel() {		
		if(session.getAttribute("userModel")==null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			
			if(!authentication.getPrincipal().equals("anonymousUser")){
				// get the user from the database
				user = userDAO.getUserByEmail(authentication.getName());
				
				if(user!=null) {
					// create a new model
					userModel = new UserModelOne();
					// set the name and the id
					
					User userentity = new ModelMapper().map(user, User.class);
					userModel.setId(user.getId());
					userModel.setFullName(user.getFirstName() + " " + user.getLastName());
					userModel.setRole(user.getRole());
					
					if(user.getRole().equals("ROLE_USER")) {
						userModel.setCart(userentity.getCart());					
					}				
	
					session.setAttribute("userModel", userModel);
					return userModel;
				}			
			}
		}
		
		return (UserModelOne) session.getAttribute("userModel");		
	}
		
}

