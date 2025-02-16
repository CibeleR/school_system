package com.schoolsystem.project.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolsystem.project.domain.Teacher;

@RestController
@RequestMapping(value="/teachers")
public class TeacherResources {

	@GetMapping
	public ResponseEntity<List<Teacher>> findAll(){
		Teacher maria = new Teacher("1", "Maria Silva", "maria@gmail.com", "Português");
		Teacher lucia = new Teacher("2", "Lucia Vieira", "lucia@gmail.com", "Matemática");
		List<Teacher> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, lucia));
		return ResponseEntity.ok().body(list);
	}
}
