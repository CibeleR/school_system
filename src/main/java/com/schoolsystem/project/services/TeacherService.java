package com.schoolsystem.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolsystem.project.domain.Teacher;
import com.schoolsystem.project.repository.TeacherRepository;
import com.schoolsystem.project.services.exception.ObjectNotFoundException;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repository;
	
	public List<Teacher> findAll(){
		return repository.findAll();
	}
	
	public Teacher findById(String id){
		Optional<Teacher> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Teacher insert(Teacher obj){
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	public Teacher update(Teacher obj) {
		Teacher newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Teacher newObj, Teacher obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setMatéria(obj.getMatéria());
	}
}
