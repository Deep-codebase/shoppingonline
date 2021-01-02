package com.shop.ecomm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;
import com.shop.ecomm.dao.UserDAO;
import com.shop.ecomm.entity.UserDto;

@Component("userdetailservice")
public class OnlineShoppingUserDtlsServicec implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userdto = userDAO.getByEmail(username);
		System.out.println("userdto in userdtls: "+userdto);
		if(userdto != null) {
			return new User(userdto.getEmail(), userdto.getPassword(),
					AuthorityUtils.createAuthorityList(userdto.getRole()));
		}
		else {
			return null;
		}
		
		
	}

}
