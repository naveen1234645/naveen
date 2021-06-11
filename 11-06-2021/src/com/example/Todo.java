package com.example;

public class Todo {
	private String todoId;
	private String desc;
	private boolean isCompleted;

	public Todo() {
		super();
	}

	public Todo(String todoId, String desc, boolean isCompleted) {
		super();
		this.todoId = todoId;
		this.desc = desc;
		this.isCompleted = isCompleted;
	}

	public String getTodoId() {
		return todoId;
	}

	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", desc=" + desc + ", isCompleted=" + isCompleted + "]";
	}



} 