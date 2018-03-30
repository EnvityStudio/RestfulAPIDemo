package com.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.OneToMany;

@Entity
@Table(name = "class")
public class ClassStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy="classStudent",cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Student> student = new HashSet<Student>();

	public ClassStudent(int id, String name, Set<Student> student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}

	public ClassStudent() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
}
