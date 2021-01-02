package com.shop.ecomm.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.shop.ecomm.entity.User;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private OnlineShoppingUserDtlsServicec onlineShoppingUserDtlsServicec;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String passedusername = authentication.getName();
		String passedpassword = (String)authentication.getCredentials();
		
		System.out.println(" passedusername and password: " + passedusername + " " + passedpassword);
		
		UserDetails originaluser = onlineShoppingUserDtlsServicec.loadUserByUsername(passedusername);
		
		if(originaluser == null || !originaluser.getUsername().equals(passedusername)) {
			System.out.println("BadCredentialsException occurred");
			throw new BadCredentialsException("Invalid User");
		}
		
		if(!originaluser.getPassword().equals(passedpassword)) {
			System.out.println("BadCredentialsException occurred");
			throw new BadCredentialsException("Invalid User");
		}
		
		Collection<? extends GrantedAuthority> authorities = originaluser.getAuthorities();
		
		return new UsernamePasswordAuthenticationToken(originaluser, originaluser.getPassword(), authorities);
	}
	
	/*
	 * public void setUserInSession(HttpSession session) {
	 * 
	 * }
	 */

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}


}
