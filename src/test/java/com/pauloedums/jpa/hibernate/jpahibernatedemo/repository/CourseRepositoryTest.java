package com.pauloedums.jpa.hibernate.jpahibernatedemo.repository;

import com.pauloedums.jpa.hibernate.jpahibernatedemo.JpaHibernateDemoApplication;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	@Autowired
	EntityManager em;
	@Test
	public void findByIdCourse() {
		Course course = repository.findById(10001L);
		assertEquals("Teste", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteByIdCourse() {
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
	}
	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = repository.findById(10001L);
		assertEquals("Teste", course.getName());
		course.setName("Teste - Unit");
		repository.save(course);

		Course course1 = repository.findById(10001L);
		assertEquals("Teste - Unit", course1.getName());
	}
	@Test
	@DirtiesContext
	public void playWithEntityManager_basic() {
		Course course = repository.findById(10001L);
		assertEquals("Teste", course.getName());
		course.setName("Teste - Unit");
		repository.save(course);

		Course course1 = repository.findById(10001L);
		assertEquals("Teste - Unit", course1.getName());
	}

	@Test
	@Transactional
	public void retriveReviewsForCourse() {
		Course course = repository.findById(10001L);
		logger.info("{}", course.getReviews());
	}
	@Test
	@Transactional
	public void retriveCourseForReviews() {
		Review review = em.find(Review.class, 50001L);
		logger.info("{}", review.getCourse());
	}

}
