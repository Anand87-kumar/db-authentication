package com.cetpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cetpa.models.User;
import com.cetpa.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired private UserRepository userRepo;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user=userRepo.findById(username).orElse(null);
		if(user==null)
			throw new UsernameNotFoundException("User id with "+username+" not found"); 
		UserDetails details=new UserDetailsImpl(user);
		return details;
	}
}
