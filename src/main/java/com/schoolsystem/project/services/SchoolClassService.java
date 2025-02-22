package com.schoolsystem.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolsystem.project.domain.SchoolClass;
import com.schoolsystem.project.repository.SchoolClassRepository;
import com.schoolsystem.project.services.exception.ObjectNotFoundException;

@Service
public class SchoolClassService {

	@Autowired
	private SchoolClassRepository repository;
	
	public List<SchoolClass> findAll(){
		return repository.findAll();
	}
	
	public SchoolClass findById(String id){
		Optional<SchoolClass> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public SchoolClass insert(SchoolClass obj){
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	public SchoolClass update(SchoolClass obj) {
		SchoolClass newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(SchoolClass newObj, SchoolClass obj) {
		newObj.setAno(obj.getAno());
	}
}
