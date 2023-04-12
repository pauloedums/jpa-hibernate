package com.pauloedums.jpa.hibernate.jpahibernatedemo.repository;

import com.pauloedums.jpa.hibernate.jpahibernatedemo.JpaHibernateDemoApplication;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Course;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpaHibernateDemoApplication.class)
class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;
	@Autowired
	EntityManager em;
	@Test
	public void findById_courseIsPresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		assertTrue(courseOptional.isPresent());
	}
	@Test
	public void findById_courseIsNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		assertFalse(courseOptional.isPresent());
	}
	@Test
	public void playingAroundWith() {
//		Course course = new Course("Microservices in 100 Steps")
//		repository.save(course);

//		course.setName("Microservices in 100 Steps - Updated");
//		repository.save(course);

	}

	@Test
	public void sort() {
		Sort sort = Sort.by( "name").ascending();
		logger.info("Sorted Courses -> {} ", repository.findAll(sort));
		logger.info("Count -> {} ", repository.count());
	}


	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> firstPage =repository.findAll(pageRequest);
		logger.info("First Page -> {} ", firstPage.getContent());
	}


	@Test
	public void findingByName() {
		logger.info("Find By Name -> {} ", repository.findByName("JPA in 50 steps"));
	}
}
