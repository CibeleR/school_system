package com.schoolsystem.project.dto;

import java.io.Serializable;

import com.schoolsystem.project.domain.SchoolClass;

public class SchoolClassDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String ano;
	
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
}
