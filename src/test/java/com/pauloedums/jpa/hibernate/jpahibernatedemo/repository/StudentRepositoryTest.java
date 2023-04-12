package com.pauloedums.jpa.hibernate.jpahibernatedemo.repository;

import com.pauloedums.jpa.hibernate.jpahibernatedemo.JpaHibernateDemoApplication;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Passport;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void someTest(){
		// Database Operation 1 - Retrieve Student
		Student student = em.find(Student.class, 20001L);
		// Database Operation 2 - Retrieve passport
		Passport passport = student.getPassport();
		// Database Operation 3 - update passport
		passport.setNumber("Z13265788888");
		// Database Operation 4 - update student
		student.setName("Ranga - updated");

	}

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);

		logger.info("student -> {}", student);
		logger.info("student courses -> {}", student.getCourses());
	}
}
