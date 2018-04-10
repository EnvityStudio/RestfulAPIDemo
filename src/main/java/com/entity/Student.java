package com.entity;

/**
 * @author ThuanEnvity 
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@ManyToOne
	@JoinColumn(name = "idclass")
	private ClassStudent classStudent;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "student_lesson", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
	@JsonBackReference
	private List<Lesson> lessons = new ArrayList<>();

	public Student(int id, String name, int age, ClassStudent classStudent, Set<Lesson> lessons) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.classStudent = classStudent;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Student() {
	}

	public ClassStudent getClassStudent() {
		return classStudent;
	}

	public void setClassStudent(ClassStudent classStudent) {
		this.classStudent = classStudent;
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

}
