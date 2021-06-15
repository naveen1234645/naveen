

package comm.example;

public class Student implements Comparable{

	private String studentId;
	private String firstName;
	private String lastName;
	private String email;
	private double gpa;
	public Student() {
		super();
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", gpa=" + gpa + "]";
	}
	@Override
	public int compareTo(Object o) {
		if(this.gpa>((Student)o).gpa)
			return -1;
		if(this.gpa<((Student)o).gpa)
			return 1;
		else
			return 0;
	}



}
