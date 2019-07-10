package com.bbnf.springboottask.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.bbnf.springboottask.model.Student;
import com.bbnf.springboottask.service.StudentService;
import com.bbnf.springboottask.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentResource {

	private StudentService studentService;

	public StudentResource(StudentService studentService) {
		this.studentService = studentService;
	}
	@GetMapping(value = "student", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() {
		return studentService.findAll();
	}

	@PostMapping(value = "student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) throws URISyntaxException {
		try {
			Student result = studentService.save(student);
			return ResponseEntity.created(new URI("/api/student/" + result.getId())).body(result);////////////
		} catch (EntityExistsException e) {
			return new ResponseEntity<Student>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping(value = "student", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws URISyntaxException {
		if (student.getId() == null) {//////////////////////////////////////////////
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

		try {
			Student result = studentService.update(student);

			return ResponseEntity.created(new URI("/api/student/" + result.getId())).body(result);////////////////////////////////
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
		studentService.delete(id);

		return ResponseEntity.ok().build();
	}
}



