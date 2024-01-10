package com.shalomTodoApp.TodoApp5.Security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserVerifcation {

//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager storeUserDetails() {
		Function<String, String> passwordencoder = 
				input -> bcrpytPasswordencoder().encode(input);
		
				UserDetails userdetails = User.builder()
				.passwordEncoder(passwordencoder )
				.username("Shalom")
				.password("myPassword")
				.roles("USER","ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(userdetails);
		
		
	}
	
	@Bean
	public PasswordEncoder bcrpytPasswordencoder() {
		return new BCryptPasswordEncoder(); 
	}
}
