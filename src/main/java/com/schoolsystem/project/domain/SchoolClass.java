package com.schoolsystem.project.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="schoolclass")
public class SchoolClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String ano;

	public SchoolClass () {
	}

	public SchoolClass(String id, String ano) {
		this.id = id;
		this.ano = ano;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolClass other = (SchoolClass) obj;
		return Objects.equals(id, other.id);
	}
}
