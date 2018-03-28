package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "nameclass")
	private String nameclass;

	/**
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @param nameclass
	 */
	public Student() {
	}

	public Student(int id, String name, int age, String nameclass) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.nameclass = nameclass;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNameclass() {
		return nameclass;
	}

	public void setNameclass(String nameclass) {
		this.nameclass = nameclass;
	}

}
