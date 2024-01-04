package com.shalomTodoApp.TodoApp5.Authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean AuthenticatePassword(String password) {
		boolean IsEqualPassword = password.equalsIgnoreCase("password");
		
		return IsEqualPassword;
	}
}
