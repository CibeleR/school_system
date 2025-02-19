package com.schoolsystem.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.schoolsystem.project.domain.Teacher;
import com.schoolsystem.project.repository.TeacherRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public void run(String... args) throws Exception {

		teacherRepository.deleteAll();
		
		Teacher mariana = new Teacher(null, "Mariana Silva", "marianas@gmail.com", "Português");
		Teacher lucas = new Teacher(null, "Lucas Fernandes", "lucasf@gmail.com", "Matemática");
		Teacher juliana = new Teacher(null, "Juliana Souza", "julianas@gmail.com", "Biologia");

		teacherRepository.saveAll(Arrays.asList(mariana, lucas, juliana));
	}

}
