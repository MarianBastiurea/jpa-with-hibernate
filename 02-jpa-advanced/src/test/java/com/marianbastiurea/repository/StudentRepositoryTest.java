package com.marianbastiurea.repository;

import com.marianbastiurea.JpaApplication;
import com.marianbastiurea.entity.Address;
import com.marianbastiurea.entity.Passport;
import com.marianbastiurea.entity.Student;
import jakarta.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class StudentRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("Student ->{}", student);
        logger.info("Passport->{}", student.getPassport());
    }

    @Test
    public void someTest() {
        studentRepository.someOperationToUnderstandPersistenceContext();
    }


    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = entityManager.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }


   @Test
    @Transactional
    public void retrieveStudentAndCourses() {
        Student student = entityManager.find(Student.class, 20001L);

        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }

    @Test
    @Transactional
    public void setAddressDetails() {
        Student student = entityManager.find(Student.class, 20001L);
        student.setAddress(new Address("No 101", "Some Street", "Hyderabad"));
        entityManager.flush();
    }
}
