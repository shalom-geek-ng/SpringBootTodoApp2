package com.shalomTodoApp.TodoApp5.Rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestApplication {

	@RequestMapping(value="")
	public String login() {
		return "loggin";
	}
}
