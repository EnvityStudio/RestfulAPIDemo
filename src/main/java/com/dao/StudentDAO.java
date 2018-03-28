package com.dao;

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
		System.out.println("myanmethuan");
		String hql = " FROM Student";
		List<Student> list = new ArrayList<>();
		list = entityManager.createQuery(hql).getResultList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		return list;
	}

}
