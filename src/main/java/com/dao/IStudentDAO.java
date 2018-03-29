package com.dao;

/**
 * @author ThuanEnvity
 * 
 */
import java.util.List;

import com.entity.Student;

public interface IStudentDAO {
	List<Student> getAllStudent();

	void addStudent(Student student);

	void deleteStudent(int idStudent);

	void updateStudent(Student student);

	Student getStudentById(int idStudent);
}
