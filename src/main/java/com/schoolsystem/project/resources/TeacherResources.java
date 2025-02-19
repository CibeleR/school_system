package com.schoolsystem.project.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolsystem.project.domain.Teacher;
import com.schoolsystem.project.services.TeacherService;

@RestController
@RequestMapping(value="/teachers")
public class TeacherResources {

	@Autowired
	private TeacherService service;
	
	@GetMapping
	public ResponseEntity<List<Teacher>> findAll(){
		List<Teacher> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
