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
import com.schoolsystem.project.dto.SchoolClassDTO;
import com.schoolsystem.project.services.SchoolClassService;

@RestController
@RequestMapping(value="/schoolclasses")
public class SchoolClassResources {

	@Autowired
	private SchoolClassService service;
	
	@GetMapping
	public ResponseEntity<List<SchoolClassDTO>> findAll(){
		List<SchoolClass> list = service.findAll();
		List<SchoolClassDTO> listDto = list.stream().map(x -> new SchoolClassDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SchoolClassDTO> findById(@PathVariable String id){
		SchoolClass obj = service.findById(id);
		return ResponseEntity.ok().body(new SchoolClassDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody SchoolClass schoolClass){
		SchoolClass obj = service.insert(schoolClass);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody SchoolClass schoolClass, @PathVariable String id){
		SchoolClass obj = service.insert(schoolClass);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}/students")
	public ResponseEntity<List<Student>> findStudents(@PathVariable String id){
		SchoolClass sc = service.findById(id);
		return ResponseEntity.ok().body(sc.getStudents());
	}
}
