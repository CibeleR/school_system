package com.schoolsystem.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.schoolsystem.project.domain.SchoolClass;
import com.schoolsystem.project.domain.Student;
import com.schoolsystem.project.domain.Teacher;
import com.schoolsystem.project.repository.SchoolClassRepository;
import com.schoolsystem.project.repository.StudentRepository;
import com.schoolsystem.project.repository.TeacherRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SchoolClassRepository schoolClassRepository;
	
	@Override
	public void run(String... args) throws Exception {

		teacherRepository.deleteAll();
		studentRepository.deleteAll();
		schoolClassRepository.deleteAll();
		
		Teacher mariana = new Teacher(null, "Mariana Silva", "marianas@gmail.com", "Português");
		Teacher lucas = new Teacher(null, "Lucas Fernandes", "lucasf@gmail.com", "Matemática");
		Teacher juliana = new Teacher(null, "Juliana Souza", "julianas@gmail.com", "Biologia");

		teacherRepository.saveAll(Arrays.asList(mariana, lucas, juliana));
		
		SchoolClass sc1a = new SchoolClass(null, "1º A");
		SchoolClass sc2b = new SchoolClass(null, "2º B");
		SchoolClass sc3c = new SchoolClass(null, "3º C");
		
		schoolClassRepository.saveAll(Arrays.asList(sc1a, sc2b, sc3c));
		
		Student ana = new Student(null, "Ana Luiza da Silva", "analu@gmail.com", sc1a);
		Student joão = new Student(null, "João Azevedo", "joaoaz@gmail.com", sc1a);
		Student giovanna = new Student(null, "Giovanna Araújo", "gio.araujo@gmail.com", sc1a);
		Student pedro = new Student(null, "Pedro Gonzaga", "pedro.g@gmail.com", sc2b);
		Student fernanda = new Student(null, "Fernanda Mathias", "fernandam@gmail.com", sc2b);
		Student gustavo = new Student(null, "Gustavo Alberto", "gus.alberto@gmail.com", sc2b);
		Student viviane = new Student(null, "Viviane de Lima", "vivilima@gmail.com", sc3c);
		Student bruno = new Student(null, "Bruno Ferreira", "b.ferreira@gmail.com", sc3c);
		Student maria = new Student(null, "Maria Estela Rodrigues", "mariae.r@gmail.com", sc3c);		
		
		studentRepository.saveAll(Arrays.asList(ana, joão, giovanna, pedro, fernanda, gustavo, viviane, bruno, maria));
		
		sc1a.getStudents().addAll(Arrays.asList(ana, joão, giovanna));
		sc2b.getStudents().addAll(Arrays.asList(pedro, fernanda, gustavo));
		sc3c.getStudents().addAll(Arrays.asList(viviane, bruno, maria));
		
		schoolClassRepository.saveAll(Arrays.asList(sc1a, sc2b, sc3c));
		
		mariana.getSchoolClass().addAll(Arrays.asList(sc1a, sc2b, sc3c));
		lucas.getSchoolClass().addAll(Arrays.asList(sc1a, sc2b, sc3c));
		juliana.getSchoolClass().addAll(Arrays.asList(sc1a, sc2b, sc3c));
		
		teacherRepository.saveAll(Arrays.asList(mariana, lucas, juliana));
	}
}
