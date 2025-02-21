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

import com.schoolsystem.project.domain.Student;
import com.schoolsystem.project.dto.StudentDTO;
import com.schoolsystem.project.services.StudentService;

@RestController
@RequestMapping(value="/students")
public class StudentResources {

	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> findAll(){
		List<Student> list = service.findAll();
		List<StudentDTO> listDto = list.stream().map(x -> new StudentDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentDTO> findById(@PathVariable String id){
		Student obj = service.findById(id);
		return ResponseEntity.ok().body(new StudentDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Student student){
		Student obj = service.insert(student);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Student student, @PathVariable String id){
		Student obj = service.insert(student);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
