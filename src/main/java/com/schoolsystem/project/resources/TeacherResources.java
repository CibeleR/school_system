package com.schoolsystem.project.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.schoolsystem.project.domain.SchoolClass;
import com.schoolsystem.project.domain.Student;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TeacherDTO> findById(@PathVariable String id){
		Teacher obj = service.findById(id);
		return ResponseEntity.ok().body(new TeacherDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Teacher teacher){
		Teacher obj = service.insert(teacher);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Teacher teacher, @PathVariable String id){
		Teacher obj = service.insert(teacher);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/schoolclasses")
	public ResponseEntity<List<SchoolClass>> findStudents(@PathVariable String id){
		Teacher teacher = service.findById(id);
		return ResponseEntity.ok().body(teacher.getSchoolClass());
	}
}
