package com.shalomTodoApp.TodoApp5.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shalomTodoApp.TodoApp5.Authentication.AuthenticationService;

@Controller
public class RestApplication {
	
	@Autowired
	private AuthenticationService authenticate;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String login() {
		return "loggin";
	}
	@RequestMapping(value="", method=RequestMethod.POST)
	public String mytodo(@RequestParam String name, ModelMap model,
			@RequestParam String password) {
		if(authenticate.AuthenticatePassword(password)) {
		model.put("name", name);
		return "Todo";
		}
		else {
			model.put("Error", "Your password is incorrect");
			return "loggin";
		}
	}
}
