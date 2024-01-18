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
		
		
//		
//		UserDetails userdetails1 = createUserDetails("Shalom", "password");
//		UserDetails userdetails2 = createUserDetails("Mason", "1234");
		
	

		UserDetails userdetails = createUserDetails("Shalom", "Password");
		UserDetails userdetails2 = createUserDetails("Dele", "Password");
		
		return new InMemoryUserDetailsManager(userdetails,userdetails2);
		
		
	}




	private UserDetails createUserDetails(String username, String password) {
		Function<String, String> passwordencoder = 
				input -> bcrpytPasswordencoder().encode(input);
		
				UserDetails userdetails = User.builder()
				.passwordEncoder(passwordencoder )
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
		return userdetails;
	}

			

	
	@Bean
	public PasswordEncoder bcrpytPasswordencoder() {
		return new BCryptPasswordEncoder(); 
	}
}
