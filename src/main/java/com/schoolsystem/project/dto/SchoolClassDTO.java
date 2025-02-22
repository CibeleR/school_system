package com.schoolsystem.project.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.schoolsystem.project.domain.SchoolClass;
import com.schoolsystem.project.domain.Student;

public class SchoolClassDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String ano;

	private List<Student> students = new ArrayList<>();
	
	public SchoolClassDTO() {
	}
	
	public SchoolClassDTO(SchoolClass obj) {
		id = obj.getId();
		ano = obj.getAno();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
