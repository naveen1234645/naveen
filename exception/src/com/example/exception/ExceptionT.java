package com.example.exception;

public class ExceptionT {
	private String todoId;
	private String desc;
	private boolean isCompleted;

	public ExceptionT() {
		super();
	}

	public ExceptionT(String todoId, String desc, boolean isCompleted) {
		super();
		this.todoId = todoId;
		this.desc = desc;
		this.isCompleted = isCompleted;
	}

	public String getExceptionT() {
		return todoId;
	}

	public void setExceptionT(String todoId) {
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
		return "ExceptionT [todoId=" + todoId + ", desc=" + desc + ", isCompleted=" + isCompleted + "]";
	}



} 


