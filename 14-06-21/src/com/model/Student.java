package com.model;

public class Student {

	private int studentId;
	private String studentName;
	private double GPA;
	public Student() {
		super();
	}
	public Student(int studentId, String studentName, double gPA) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		GPA = gPA;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", GPA=" + GPA + "]";
	}




}
