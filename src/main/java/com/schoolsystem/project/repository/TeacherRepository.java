package com.schoolsystem.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.schoolsystem.project.domain.Teacher;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

	
}
