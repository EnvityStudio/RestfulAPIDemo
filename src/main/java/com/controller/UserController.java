package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.TokenAuthenticationService;
import com.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value ="/authentication",
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE}
			)
	@ResponseBody
	public ResponseEntity<Void> authorize(@RequestBody User user)
	{
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		HttpHeaders header = new HttpHeaders();
		User user1 = userService.login(user.getName(), user.getPassword());
		if(user1==null)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		else {
		String token = TokenAuthenticationService.addAuthentication(user);
		header.add("token",token);
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
		}
		
	}
}
