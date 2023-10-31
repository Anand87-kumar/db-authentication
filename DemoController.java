package com.cetpa.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController 
{
	 @GetMapping("add")
	    public String method1(HttpServletResponse response) {
	        // Creating a cookie
	        Cookie cookie = new Cookie("myCookie", "cookieValue");

	        // Setting cookie properties (optional)
	        cookie.setMaxAge(3600); // in seconds - e.g., 1 hour
	        cookie.setPath("/"); // specify the path

	        // Adding the cookie to the response
	        response.addCookie(cookie);

	        return "Add user API called";
	    }
	@GetMapping("delete")
	public String method2()
	{
		return "Delete user API called";
	}
	@GetMapping("update")
	public String method3()
	{
		return "Update user API called";
	}
	@GetMapping("show")
	public String method4()
	{
		return "Show user API called";
	}
	
}
