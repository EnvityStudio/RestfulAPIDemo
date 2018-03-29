package com.dao;

/**
 * @author ThuanEnvity
 * 
 */
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entity.Student;

@Transactional
@Repository
public class StudentDAO implements IStudentDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		String hql = " FROM Student";
		List<Student> list = new ArrayList<>();
		list = entityManager.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
	}

	@Override
	public void deleteStudent(int idStudent) {
		entityManager.remove(getStudentById(idStudent));
	}

	@Override
	public void updateStudent(Student student) {
		Student student1 = getStudentById(student.getId());
		student1.setAge(student.getAge());
		student1.setName(student.getName());
		student1.setNameclass(student.getNameclass());
		entityManager.flush();
	}

	@Override
	public Student getStudentById(int idStudent) {
		return entityManager.find(Student.class, idStudent);

	}

}
