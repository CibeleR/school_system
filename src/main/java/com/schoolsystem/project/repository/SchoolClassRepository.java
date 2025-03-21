package com.schoolsystem.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.schoolsystem.project.domain.SchoolClass;

@Repository
public interface SchoolClassRepository extends MongoRepository<SchoolClass, String> {

	
}
