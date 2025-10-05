package com.marianbastiurea.repository;

import com.marianbastiurea.entity.Course;
import com.marianbastiurea.entity.Passport;
import com.marianbastiurea.entity.Student;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }
        return student;
    }


    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        entityManager.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void someOperationToUnderstandPersistenceContext() {
        Student student = entityManager.find(Student.class, 20001L);

        Passport passport = student.getPassport();

        passport.setNumber("E123457");

        student.setName("Ranga - updated");
    }

    public void insertHardcodedStudentAndCourse() {
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        entityManager.persist(student);
        entityManager.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        entityManager.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course) {
        student.addCourse(course);
        course.addStudent(student);

        entityManager.persist(student);
        entityManager.persist(course);
    }
}
