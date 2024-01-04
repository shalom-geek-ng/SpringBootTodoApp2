package com.shalomTodoApp.TodoApp5.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shalomTodoApp.TodoApp5.Authentication.AuthenticationService;
import com.shalomTodoApp.TodoApp5.Todo.TodoClass;
import com.shalomTodoApp.TodoApp5.Todo.TodoService;

@Controller
public class RestApplication {
	
	@Autowired
	private AuthenticationService authenticate;
	@Autowired
	private TodoService todo;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String loggin() {
		return "loggin";
	}
	@RequestMapping(value="", method=RequestMethod.POST)
	public String mytodo(@RequestParam String name, ModelMap model,
			@RequestParam String password) {
		if(authenticate.AuthenticatePassword(password)) {
			List<TodoClass> todos = todo.todoList();
			model.put("todos", todos);
			model.put("name", name);
		return "Todo";
		}
		else {
			model.put("Error", "Your password is incorrect");
			return "loggin";
		}
	}
}
