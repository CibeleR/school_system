package com.schoolsystem.project.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.schoolsystem.project.domain.SchoolClass;
import com.schoolsystem.project.domain.Teacher;

public class TeacherDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String matéria;
	
	private List<SchoolClass> schoolClass = new ArrayList<>();
	
	public TeacherDTO() {
	}
	
	public TeacherDTO(Teacher obj) {
		id = obj.getId();
		nome = obj.getNome();
		matéria = obj.getMatéria();
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

	public String getMatéria() {
		return matéria;
	}

	public void setMatéria(String matéria) {
		this.matéria = matéria;
	}

	public List<SchoolClass> getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(List<SchoolClass> schoolClass) {
		this.schoolClass = schoolClass;
	}
}
