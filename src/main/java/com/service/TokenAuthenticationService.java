package com.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	private final static String NAME_USER = "name";
	private final static String PASSWORD = "password";

	// create token
	public static String addAuthentication(User user) {
		String nameUser = user.getName();
		String password = user.getPassword();
		String JWT = Jwts.builder().claim(NAME_USER, nameUser).claim(PASSWORD, password)
				.setExpiration(new Date(System.currentTimeMillis() + 3600)).signWith(SignatureAlgorithm.HS256, "secret")
				.compact();
		System.out.println(JWT);
		return JWT;
	}

	// parse Token
	public static User getAuthentication(HttpServletRequest request) {

		String token = request.getHeader("token");																														
		if (token != null && !token.trim().isEmpty()) {
			Claims claims = Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
			
			String nameUser = (String) claims.get(NAME_USER);
			String password = (String) claims.get(PASSWORD);
			User user = new User();
			user.setName(nameUser);
			user.setPassword(password);
			return user;
		}
		return null;
	}

}
