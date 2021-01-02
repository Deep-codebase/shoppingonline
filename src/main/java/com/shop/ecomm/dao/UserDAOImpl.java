package com.shop.ecomm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.ecomm.entity.Address;
import com.shop.ecomm.entity.Cart;
import com.shop.ecomm.entity.User;
import com.shop.ecomm.entity.UserDto;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public UserDto getByEmail(String email) {
		Session session = entityManager.unwrap(Session.class);
		String selectQuery = "FROM User WHERE email = :email";
		try {
			User userentity = session
						.createQuery(selectQuery,User.class)
							.setParameter("email",email)
								.getSingleResult();
			UserDto returnValue = new ModelMapper().map(userentity, UserDto.class);
			System.out.println("UserDto in DAO Impl: " + returnValue);
			return returnValue;
			
			}
			catch(Exception ex) {
				return null;
			}
	}

	@Override
	public User getUserByEmail(String email) {
		Session session = entityManager.unwrap(Session.class);
		String selectQuery = "FROM User WHERE email = :email";
		try {
			User userentity = session
						.createQuery(selectQuery,User.class)
							.setParameter("email",email)
								.getSingleResult();
			
			return userentity;
			
			}
			catch(Exception ex) {
				return null;
			}
	}
	
	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public boolean addUser(User user) {
		Session session = entityManager.unwrap(Session.class);
		try {			
			session.save(user);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
		Session session = entityManager.unwrap(Session.class);
		try {			
			// will look for this code later and why we need to change it
			session.save(cart);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		Session session = entityManager.unwrap(Session.class);
		try {			
			// will look for this code later and why we need to change it
			session.save(address);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public Address getBillingAddress(int userId) {
		Session session = entityManager.unwrap(Session.class);
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :isBilling";
		try{
		return session
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isBilling", true)
						.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
	}
	
	@Override
	public List<Address> listShippingAddresses(int userId) {
		Session session = entityManager.unwrap(Session.class);
		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :isShipping ORDER BY id DESC";
		return session
					.createQuery(selectQuery,Address.class)
						.setParameter("userId", userId)
						.setParameter("isShipping", true)
							.getResultList();
		
	}

	

}
