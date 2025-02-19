package com.schoolsystem.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolsystem.project.domain.Teacher;
import com.schoolsystem.project.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repository;
	
	public List<Teacher> findAll(){
		return repository.findAll();
	}
}
