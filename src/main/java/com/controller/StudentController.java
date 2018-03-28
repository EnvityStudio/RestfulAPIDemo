package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.IStudentService;

@RestController
public class StudentController {
	@Autowired
	private IStudentService iStudentService;

	@RequestMapping("/student")
	public Student getAllStudent() {
		System.out.println("Aaa");
		List<Student> list = iStudentService.getAllStudent();
		return new Student(list.get(2).getId(), list.get(2).getName(), list.get(2).getAge(),
				list.get(2).getNameclass());
	}
}
