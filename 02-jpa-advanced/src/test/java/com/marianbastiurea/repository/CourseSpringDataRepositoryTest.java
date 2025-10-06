package com.marianbastiurea.repository;

import com.marianbastiurea.JpaApplication;
import com.marianbastiurea.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = JpaApplication.class)
class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    void findById_CoursePresent() {
        Optional<Course> courseOptional = repository.findById(10001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(20001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    void playingAroundWithSpringDataRepository() {
        //Course course = new Course("Microservices in 100 Steps");
        //repository.save(course);

        //course.setName("Microservices in 100 Steps - Updated");
        //repository.save(course);
        logger.info("Courses -> {} ", repository.findAll());
        logger.info("Count -> {} ", repository.count());
    }

    @Test
    void sort() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        logger.info("Sorted Courses -> {} ", repository.findAll(sort));
    }

    @Test
    void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info("First Page -> {} ", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        logger.info("Second Page -> {} ", secondPage.getContent());
    }

    @Test
    void findUsingName() {
        logger.info("FindByName -> {} ", repository.findByName("JPA"));
    }

    @Test
    void findUsingStudentsName() {
        logger.info("findUsingStudentsName -> {} ", repository.findByName("Ranga"));
    }

}
