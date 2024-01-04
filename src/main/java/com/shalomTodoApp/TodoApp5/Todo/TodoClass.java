package com.shalomTodoApp.TodoApp5.Todo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class TodoClass {
	private int id;
	private String name;
	private String whatToDo;
	private LocalDate date;
	private boolean done;
	
//	Constructor
	public TodoClass(){
		
	}
	

	
	
public TodoClass(int id, String name, String whatToDo, LocalDate date, boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.whatToDo = whatToDo;
		this.date = date;
		this.done = done;
	}




	//	Getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public String getWhatToDo() {
		return whatToDo;
	}

	public LocalDate getDate() {
		return date;
	}
	public boolean isDone() {
		return done;
	}
	
//	Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWhatToDo(String whatToDo) {
		this.whatToDo = whatToDo;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setDone(boolean done) {
		this.done = done;
	}




	@Override
	public String toString() {
		return "TodoClass [id=" + id + ", name=" + name + ", whatToDo=" + whatToDo + ", date=" + date + ", done=" + done
				+ "]";
	}

//	ToString

	
	
	
}
