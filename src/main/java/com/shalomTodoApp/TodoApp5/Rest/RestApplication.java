package com.shalomTodoApp.TodoApp5.Rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shalomTodoApp.TodoApp5.Authentication.AuthenticationService;
import com.shalomTodoApp.TodoApp5.Todo.TodoClass;
import com.shalomTodoApp.TodoApp5.Todo.TodoService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
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
	
	@RequestMapping(value="/addNewTodo", method=RequestMethod.GET)
	public String addmyTodo(ModelMap model) {
		TodoClass todo = new TodoClass(0,(String) model.get("name"),"Write a todo",LocalDate.now(),
				true);
		model.put("myTodo", todo);
		return "addTodo";
	}
	@RequestMapping(value="/addNewTodo", method=RequestMethod.POST)
	public String getmyTodo(ModelMap model,@ModelAttribute("myTodo") @Valid TodoClass myTodo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		List<TodoClass> todos = todo.todoList();
		model.put("todos", todos);
		todo.addedTodo((String) model.get("name"), myTodo.getWhatToDo(), myTodo.getDate(), false);
	return "Todo";
	}
	
	@RequestMapping(value="/delete-todo")
	public String deleteTodo(@RequestParam int id,ModelMap model) {
		List<TodoClass> todos = todo.todoList();
		todo.deleteTodo(id);
		model.put("todos", todos);
	return "Todo";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id,ModelMap model) {
		TodoClass mytodo = todo.showUpdateTodo(id);
		model.put("myTodo", mytodo);
		return "addTodo";
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updatemyTodo(@RequestParam int id,ModelMap model,@ModelAttribute("myTodo") @Valid TodoClass myTodo) {
		List<TodoClass> todos = todo.todoList();
		String username = (String) model.get("name");
		model.put("todos", todos);
		myTodo.setName(username);
		todo.UpdateTodo(myTodo);
	return "Todo";
	}
	
}
