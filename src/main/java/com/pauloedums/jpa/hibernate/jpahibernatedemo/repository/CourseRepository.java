package com.pauloedums.jpa.hibernate.jpahibernatedemo.repository;

import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Review;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.ReviewRating;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public Course save(Course course){
        if(course.getId() == null){
            em.persist(course);
        }else {
            em.merge(course);
        }

        return course;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager(){
        Course course = new Course("Web Services in 100 Steps");
        em.persist(course);
        em.flush();
    }

    public void addHardcodedReviewsForCourses() {
        // get the course 10003
        Course course = findById(10001L);
        // add 2 reviews to it
        Review review1 = new Review(ReviewRating.FIVE, "Amazing Course");
        Review review2 = new Review(ReviewRating.FOUR, "Good Course");

        // setting the relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        // save it to the database
        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsForCourses(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);

        for(Review review: reviews){
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }
}
