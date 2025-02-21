package com.schoolsystem.project.dto;

import java.io.Serializable;

import com.schoolsystem.project.domain.Student;

public class StudentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public StudentDTO() {
	}
	
	public StudentDTO(Student obj) {
		id = obj.getId();
		nome = obj.getNome();
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
}
