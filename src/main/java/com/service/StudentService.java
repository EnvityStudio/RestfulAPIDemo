package com.service;

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
	


}
