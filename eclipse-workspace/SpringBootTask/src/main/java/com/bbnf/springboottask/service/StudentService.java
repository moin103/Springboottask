package com.bbnf.springboottask.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnf.springboottask.model.Student;
import com.bbnf.springboottask.repository.StudentRepository;


@Service
public class StudentService {
	private StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student save(Student student) {
		if (student.getId() != null && studentRepository.existsById(student.getId())) {//exists
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return studentRepository.save(student);
	}

	public Student update(Student student) {
		if (student.getId()!= null && !studentRepository.existsById(student.getId())) { //exists
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
	}

		return studentRepository.save(student);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Optional<Student> findOne(int id) {
		return studentRepository.findById(id); //boro change
	}

	public void delete(int id) {
		studentRepository.deleteById(id); //delete
	}
}