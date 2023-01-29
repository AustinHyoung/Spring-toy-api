package com.toy.api.login.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.toy.api.login.service.LoginService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j2
@RestController
@RequestMapping("/apis")
public class LoginController {
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	
	@RequestMapping(value = "/a")
	public Object test() {
		log.fatal("fatal");
        log.error("ERROR");
        log.warn("WARN");
        log.info("INFO");
        log.debug("DEBUG");
        log.trace("TRACE");
		
		return "hi";
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/workspace")
	public String workspace(HttpSession session,
			@RequestParam(value = "email", defaultValue = "") String name,
			@RequestParam(value = "password", defaultValue = "") String password)
	{
		try {
			
			Map<String, Object> getUser = (Map<String, Object>) session.getAttribute("user_info");
			
			if(getUser != null) {
				return "redirect:/login";
			}
			
			return "/workspace";
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
	@PostMapping(value = "/login")
	public @ResponseBody Object login(HttpSession session, @RequestBody Map<String, Object> paramMap)
	{
		try {
			Map<String, Object> resObj = new HashMap<String, Object>();
			Map<String, Object> userChk = loginService.getUser(paramMap);
			
			if(userChk == null) {
				resObj.put("code", HttpStatus.NOT_FOUND.value());
				resObj.put("msg", "이메일 또는 비밀번호를 다시 확인해주세요.");
				
				return resObj;
			}
			
			resObj.put("code", HttpStatus.OK.value());
			resObj.put("msg", "로그인 완료");
			
			session.setAttribute("user_info", userChk);
			session.setMaxInactiveInterval(60*60*24);
			
			return resObj;
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
}
