package com.schoolsystem.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.schoolsystem.project.domain.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	
}
