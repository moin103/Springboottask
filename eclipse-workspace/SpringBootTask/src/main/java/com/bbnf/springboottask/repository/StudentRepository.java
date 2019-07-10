package com.bbnf.springboottask.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;

import com.bbnf.springboottask.model.Student;



public interface StudentRepository extends JpaRepository<Student, Integer>{
	//List<Student> findByActive(@Param("active") Boolean active);
	Student findByName(String name);
}