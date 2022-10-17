package com.adminbillar.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/main")
	public String home(Principal principal) {
		return "Hola, "+principal.getName().toUpperCase()+" eres Bienvenido!";
	}
	
	@PreAuthorize("hasAuthority('SCOPE_read')")
	@GetMapping("/secure")
	public String secure() {
		return "This now is secure!";
	}
}
