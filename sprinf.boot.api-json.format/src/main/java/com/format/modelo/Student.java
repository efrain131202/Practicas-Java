package com.format.modelo;

import java.util.List;
import java.util.Set;

public class Student {
	
	private Integer integer;
	private Set<String> subjects;
	private List<Integer> marks;
	private String [] grades;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer integer, Set<String> subjects, List<Integer> marks, String[] grades) {
		super();
		this.integer = integer;
		this.subjects = subjects;
		this.marks = marks;
		this.grades = grades;
	}
	public Integer getInteger() {
		return integer;
	}
	public void setInteger(Integer integer) {
		this.integer = integer;
	}
	public Set<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}
	public List<Integer> getMarks() {
		return marks;
	}
	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	public String[] getGrades() {
		return grades;
	}
	public void setGrades(String[] grades) {
		this.grades = grades;
	}
	
	
}
