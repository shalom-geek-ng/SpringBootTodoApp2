package com.shalomTodoApp.TodoApp5.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

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
	public void addedTodo(String name, String description, LocalDate date,Boolean done) {
		todo.add(new TodoClass(++count,name,description,date,done));
	}
public void deleteTodo(int id) {
	Predicate<? super TodoClass> predicate = TodoPredicate -> TodoPredicate.getId() == id;
	todo.removeIf(predicate );
}
public TodoClass showUpdateTodo(int id) {
	Predicate<? super TodoClass> predicate = TodoPredicate -> TodoPredicate.getId() == id;
	TodoClass mytodo = todo.stream().filter(predicate).findFirst().get();
	return mytodo;
}

public void UpdateTodo(@Valid TodoClass todoBean) {
	deleteTodo(todoBean.getId());
	todo.add(todoBean);
}



}
