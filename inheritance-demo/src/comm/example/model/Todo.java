package comm.example.model;

import java.util.UUID;

public class Todo {

	private String todoId;
	private String desc;
	private boolean isCompleted;

	// blank final variable
	/*
	 * private final int a;
	 * 
	 * 
	 * { a=100; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * //we can not extends any final class //we can not override any final method
	 * 
	 * public final String getDetails() { return
	 * "ToDo ID: "+todoId+" Desc: "+desc+" isCompleted? "+isCompleted; }
	 */
	public Todo() {
		super();
	}

	/*
	 * public Todo(String desc, boolean isCompleted) { super(); this.todoId =
	 * UUID.randomUUID().toString(); this.desc = desc; this.isCompleted =
	 * isCompleted; }
	 */

	public final void createTodo(String desc, boolean isCompleted) {
		this.todoId = "demo-todo";
		this.desc = desc;
		this.isCompleted = isCompleted;
	}

	public final String getDetails() {
		return "ToDo ID: " + todoId + " Desc: " + desc + " isCompleted? " + isCompleted;
	}

	@Override
	public String toString() {
		return "ToDo ID: " + todoId + " Desc: " + desc + " isCompleted? " + isCompleted;
	}

	@Override
	public boolean equals(Object obj) {
		Todo todo = null;
		if (obj instanceof Todo) {
			todo = (Todo) obj;
		}
		if((this.todoId==todo.todoId) &&(this.desc==todo.desc) &&(this.isCompleted==todo.isCompleted))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}