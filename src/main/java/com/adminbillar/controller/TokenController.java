package com.adminbillar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminbillar.entity.LoginRequest;
import com.adminbillar.service.impl.TokenService;

@RestController
@RequestMapping
public class TokenController {
	
	private Logger logger = LoggerFactory.getLogger(TokenController.class);
	
	@Autowired
	private TokenService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/token")
	public String token(@RequestBody LoginRequest userLogin) {
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password()));
			
		return service.generateToken(authentication);
		
		
	}

}
