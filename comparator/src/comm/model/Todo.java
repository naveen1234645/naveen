package comm.model;

public class Todo {
	private String todoId;
	private String desc;
	private Integer priority;
	public Todo() {
		super();
	}
	public Todo(String todoId, String desc, Integer priority) {
		super();
		this.todoId = todoId;
		this.desc = desc;
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", desc=" + desc + ", priority=" + priority + "]";
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
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}



}


