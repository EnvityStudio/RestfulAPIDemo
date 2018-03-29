package com.service;

/**
 * @author ThuanEnvity
 * 
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IStudentDAO;
import com.entity.Student;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentDAO iStudentDAO;

	@Override
	public List<Student> getAllStudent() {

		return iStudentDAO.getAllStudent();
	}

	@Override
	public void addStudent(Student student) {
		iStudentDAO.addStudent(student);
	}

	@Override
	public void deleteStudent(int idStudent) {
		iStudentDAO.deleteStudent(idStudent);
	}

	@Override
	public void updateStudent(Student student) {
		iStudentDAO.updateStudent(student);
	}

	@Override
	public Student getStudentById(int idStudent) {
		
		return iStudentDAO.getStudentById(idStudent);
	}

}
