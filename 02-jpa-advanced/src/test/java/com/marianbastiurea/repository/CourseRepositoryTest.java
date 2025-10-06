package com.marianbastiurea.repository;

import com.marianbastiurea.JpaApplication;
import com.marianbastiurea.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;


    @Test
    public void findById() {
        Course course = courseRepository.findById(10001L);
        assertEquals("JPA", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        courseRepository.deleteById(10002L);
        assertNull(courseRepository.findById(10002L));
    }

    @Test
    public void saveCourse() {
        //get course
        Course course = courseRepository.findById(10003L);
        assertEquals("Tomcat", course.getName());

        //set name
        course.setName("Tomcat updated");
        courseRepository.save(course);

        //check value

        Course course1 = courseRepository.findById(10003L);
        assertEquals("Tomcat updated", course1.getName());
    }


}
