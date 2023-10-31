package com.cetpa.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cetpa.models.User;
import com.cetpa.models.UserRole;

public class UserDetailsImpl implements UserDetails 
{
	private User user;
	
	public UserDetailsImpl(User user)
	{
		this.user = user;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		List<UserRole> roles=user.getRoles();
		/*List<GrantedAuthority> list=new ArrayList<>();
		for(UserRole role:roles)
		{
			list.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
		}
		return list;*/
		return roles.stream().map(role->new SimpleGrantedAuthority("ROLE_"+role.getRole())).collect(Collectors.toList());
	}
	public String getPassword() 
	{
		return user.getPassword();
	}
	public String getUsername() 
	{
		return user.getName();
	}
	public boolean isAccountNonExpired() 
	{
		return true;
	}
	public boolean isAccountNonLocked() 
	{
		/*if(user.getUserid().equals("rehan123"))
			return false;*/
		return true;
	}
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}
	public boolean isEnabled() 
	{
		return true;
	}
}
