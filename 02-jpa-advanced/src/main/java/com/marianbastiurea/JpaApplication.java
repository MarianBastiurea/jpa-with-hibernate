package com.marianbastiurea;

import com.marianbastiurea.entity.Course;
import com.marianbastiurea.repository.CourseRepository;
import com.marianbastiurea.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(JpaApplication.class);

    @Autowired
    CourseRepository repository;

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.saveStudentWithPassport();


//        Course course=repository.findById(10001L);
//        logger.info("this is your course -> {}", course);
//
//        repository.deleteById(10001L);
//
//        repository.save(new Course("Microservice"));

    }
}
