package com.marianbastiurea.repository;

import com.marianbastiurea.JpaApplication;
import com.marianbastiurea.entity.Course;
import com.marianbastiurea.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class JPQLTest {

    @Autowired
    EntityManager entityManager;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void jpqlCreateQuery() {
        List resultList = entityManager.createQuery("Select c From Course c").getResultList();
        logger.info("Select c From Course c", resultList);
    }

    @Test
    public void jpqlTypedQuery() {
        TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c", resultList);
    }

    @org.junit.jupiter.api.Test
    public void jpql_courses_without_students() {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);

    }


    @org.junit.jupiter.api.Test
    public void jpql_courses_with_atleast_2_students() {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);

    }

    @org.junit.jupiter.api.Test
    public void jpql_courses_ordered_by_students() {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @org.junit.jupiter.api.Test
    public void jpql_students_with_passports_in_a_certain_pattern() {
        TypedQuery<Student> query = entityManager.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @org.junit.jupiter.api.Test
    public void join() {
        Query query = entityManager.createQuery("Select c, s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }

    @org.junit.jupiter.api.Test
    public void left_join() {
        Query query = entityManager.createQuery("Select c, s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }

    @org.junit.jupiter.api.Test
    public void cross_join() {
        Query query = entityManager.createQuery("Select c, s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course{} Student{}", result[0], result[1]);
        }
    }
}
