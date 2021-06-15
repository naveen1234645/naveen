package comm.example;




public class Student implements Comparable{

	private String id;
	private String  name;
	private String grade;




	public Student() {
		super();
	}




	public Student(String id,String name, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	protected String getName() {
		return name;
	}




	protected void setName(String name) {
		this.name = name;
	}




	protected String getGrade() {
		return grade;
	}




	protected void setGrade(String grade) {
		this.grade = grade;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}




	@Override
	public int compareTo(Object o) {
		return grade.compareTo(((Student)o).getGrade());

	}





}