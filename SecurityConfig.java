package com.cetpa.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired private UserDetailsService service;
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(service);
	}
	protected void configure(HttpSecurity http) throws Exception 
	{
		//http.authorizeRequests().antMatchers("/demo/add").hasAnyRole("admin").anyRequest().fullyAuthenticated().and().formLogin();
		http.authorizeRequests()
		.antMatchers("/demo/add")
		.hasAnyRole("admin")
		.antMatchers("/demo/show")
		.permitAll()
		.anyRequest()
		.fullyAuthenticated()
		.and()
		.formLogin();
	}
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	//http://localhost:9090/demo/add
	//http://localhost:9090/demo/show
	//http://localhost:9090/demo/delete

}
