package com.schoolsystem.project.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolsystem.project.domain.Teacher;
import com.schoolsystem.project.dto.TeacherDTO;
import com.schoolsystem.project.services.TeacherService;

@RestController
@RequestMapping(value="/teachers")
public class TeacherResources {

	@Autowired
	private TeacherService service;
	
	@GetMapping
	public ResponseEntity<List<TeacherDTO>> findAll(){
		List<Teacher> list = service.findAll();
		List<TeacherDTO> listDto = list.stream().map(x -> new TeacherDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
