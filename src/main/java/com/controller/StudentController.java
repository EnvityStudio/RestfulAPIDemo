package com.controller;

/**
 * @author ThuanEnvity
 * 
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Lesson;
import com.entity.Student;
import com.service.IStudentService;

@RestController
public class StudentController {
	@Autowired
	private IStudentService iStudentService;

	@RequestMapping("/allstudents")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> list = iStudentService.getAllStudent();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}
	@RequestMapping("/alllessons")
	public ResponseEntity<List<Lesson>> getAllLessons(){
		List<Lesson> list = iStudentService.getListLesson();
		return new ResponseEntity<List<Lesson>> (list,HttpStatus.OK);
	}

	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		Student student = iStudentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PostMapping("add")
	public ResponseEntity<Void> addStudent(@RequestBody Student student) {
		iStudentService.addStudent(student);
		HttpHeaders headers =new HttpHeaders();
		headers.add("message", "success");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable ("id") int idStudent)
	{
		iStudentService.deleteStudent(idStudent);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	@PutMapping("edit")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)
	{
		iStudentService.updateStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}
