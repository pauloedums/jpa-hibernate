package com.pauloedums.jpa.hibernate.jpahibernatedemo;

import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.FullTimeEmployee;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.PartTimeEmployee;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Student;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.repository.CourseRepository;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.repository.EmployeeRepository;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaHibernateDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//studentRepository.saveStudentWithPassport();
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review("5", "Great Hands-on Stufff"));
//		reviews.add(new Review("5", "Hatsoff"));
//		courseRepository.addReviewsForCourses(10001L, reviews);

		//studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));;
		/*
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		logger.info("All FullTimeEmployee -> {}", employeeRepository.retrieveAllFullTimeEmployees());
		logger.info("All PartTimeEmployee -> {}", employeeRepository.retrieveAllPartTimeEmployees());
		*/
	}
}
