package com.shalomTodoApp.TodoApp5.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserVerifcation {

//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetails(){
	
	UserDetails persondetails = User.withDefaultPasswordEncoder()
			.username("Shalom")
			.password("MyPassword")
			.roles("USER","ADMIN")
			.build();
	
	return new InMemoryUserDetailsManager(persondetails);
	}
}
