package com.bbnf.springboottask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Entity
@Table(name="Student")
@EntityListeners(AuditingEntityListener.class)
public class Student {
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Name")
	private String name;
	@Column(name="Id")
	private Integer id;
	@Column(name="Age")
	private Integer age;
	@Column(name="Address")
	private String address;
	@Column(name="DOB")
	private Date dob;

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	
	
}