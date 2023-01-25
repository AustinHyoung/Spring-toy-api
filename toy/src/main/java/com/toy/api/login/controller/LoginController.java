package com.toy.api.login.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toy.api.login.service.LoginService;

import jakarta.annotation.Resource;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/apis")
public class LoginController {
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	
	@RequestMapping(value="/a")
	public Object test() {
		return "hello world";
	}
	
	@RequestMapping(value="/user")
	public Object getUser() {
		try {
			return loginService.getUser();
			
		} catch(Exception e) {
			e.printStackTrace();
			return e;
		}
	}
}
