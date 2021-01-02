package com.shop.ecomm.dao;

import java.util.List;

import com.shop.ecomm.entity.Address;
import com.shop.ecomm.entity.Cart;
import com.shop.ecomm.entity.User;
import com.shop.ecomm.entity.UserDto;

public interface UserDAO {

	// user related operation
	UserDto getByEmail(String email);
	User get(int id);

	User getUserByEmail(String email);
	
	boolean addUser(User user);
	
	boolean addCart(Cart cart);
	
	// adding and updating a new address
//	Address getAddress(int addressId);
	boolean addAddress(Address address);
//	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	

	
}
