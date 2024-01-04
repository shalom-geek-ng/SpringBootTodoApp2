package com.shalomTodoApp.TodoApp5.Todo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class TodoClass {
	private int id;
	private String name;
	private String WhatToDO;
	private LocalDate date;
	private boolean done;
	
//	Constructor
	public TodoClass(){
		
	}
	
	public TodoClass(int id, String name, String whatToDO, LocalDate date, boolean done) {
		super();
		this.id = id;
		this.name = name;
		WhatToDO = whatToDO;
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
	public String getWhatToDO() {
		return WhatToDO;
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
	public void setWhatToDO(String whatToDO) {
		WhatToDO = whatToDO;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setDone(boolean done) {
		this.done = done;
	}

//	ToString
	@Override
	public String toString() {
		return "TodoClass [id=" + id + ", name=" + name + ", WhatToDO=" + WhatToDO + ", date=" + date + ", done=" + done
				+ "]";
	}
	
	
	
}
