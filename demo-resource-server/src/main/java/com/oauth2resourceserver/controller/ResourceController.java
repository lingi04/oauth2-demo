package com.oauth2resourceserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResourceController {
	
	@GetMapping("/profile")
    public ResponseEntity<UserProfile> myProfile() {
        String username = (String) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String email = username + "@mailinator.com";

        UserProfile profile = new UserProfile(username, email);

        return ResponseEntity.ok(profile);
    }
	
	static class UserProfile{
		private String name;

	    private String email;

	    public UserProfile(String name, String email) {
	        super();
	        this.name = name;
	        this.email = email;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }
	}
}