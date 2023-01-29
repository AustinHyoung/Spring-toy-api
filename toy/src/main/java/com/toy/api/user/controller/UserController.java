package com.toy.api.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/apis")
public class UserController {
	
	
	@PostMapping(value = "/logout")
	public @ResponseBody Object logout(HttpSession session) {
		Map<String, Object> resObj = new HashMap<String, Object>();
		
		try {
			
			System.out.println("logout");
			resObj.put("code", HttpStatus.OK.value());
			
			session.removeAttribute("user_info");
			
			return resObj;
			
		} catch (Exception e) {
			resObj.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
			
			return resObj;
		}
	}
	
}
