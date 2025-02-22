package com.schoolsystem.project.dto;

import java.io.Serializable;

import com.schoolsystem.project.domain.SchoolClass;
import com.schoolsystem.project.domain.Student;

public class StudentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private SchoolClass schoolClass;
	
	public StudentDTO() {
	}
	
	public StudentDTO(Student obj) {
		id = obj.getId();
		nome = obj.getNome();
		schoolClass = obj.getSchoolClass();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}
}
