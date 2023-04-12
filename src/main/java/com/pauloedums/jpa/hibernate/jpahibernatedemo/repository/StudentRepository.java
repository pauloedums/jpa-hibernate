package com.pauloedums.jpa.hibernate.jpahibernatedemo.repository;

import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Course;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Passport;
import com.pauloedums.jpa.hibernate.jpahibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class, id);
    }

    public Student save(Student student){
        if(student.getId() == null){
            em.persist(student);
        }else {
            em.merge(student);
        }

        return student;
    }

    public void deleteById(Long id){
        Student student = findById(id);
        em.remove(student);
    }



    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z132456");
        em.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }

    public void insertHardcodedStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course){
        student.addCourse(course);
        course.addStudent(student);

        em.persist(student);
        em.persist(course);
    }

}
