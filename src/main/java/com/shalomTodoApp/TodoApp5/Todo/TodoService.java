package com.shalomTodoApp.TodoApp5.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class TodoService {
	List <TodoClass> todo = new ArrayList<TodoClass>();
	int count=0;
	
	@PostConstruct
	public void myTodo() {
		todo.add(new TodoClass(++count,"Shalom","Eat today",LocalDate.now(),true));
		todo.add(new TodoClass(++count,"Shalom","Code today",LocalDate.now(),true));
	}
	public List<TodoClass> todoList(){
		return todo;
	}
}
