package com.pauloedums.jpa.hibernate.jpahibernatedemo.repository;

import com.pauloedums.jpa.hibernate.jpahibernatedemo.JpaHibernateDemoApplication;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = JpaHibernateDemoApplication.class)
public class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void java_api_basic() {
        // Select c From Course c
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);



        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }

    @Test
    public void all_courses_having_100_steps() {
        // Select c From Course c
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Predicate like100Steps = cb.like(courseRoot.get("name"), "%50 steps");
        cq.where(like100Steps);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }


    @Test
    public void all_courses_without_students() {
        // Select c From Course c
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
        cq.where(studentsIsEmpty);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }


    @Test
    public void join() {
        // Select c From Course c
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Join<Object, Object> join = courseRoot.join("students");

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }


    @Test
    public void left_join() {
        // Select c From Course c
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }
    @Test
    public void inner_join() {
        // Select c From Course c
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Join<Object, Object> join = courseRoot.join("students", JoinType.INNER);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List resultList = query.getResultList();
        logger.info("Typed Query -> {}", resultList);
    }
}
