package com.marianbastiurea;

import com.marianbastiurea.entity.Course;
import com.marianbastiurea.entity.FullTimeEmployee;
import com.marianbastiurea.entity.PartTimeEmployee;
import com.marianbastiurea.entity.Review;
import com.marianbastiurea.repository.CourseRepository;
import com.marianbastiurea.repository.EmployeeRepository;
import com.marianbastiurea.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(JpaApplication.class);

    @Autowired
    CourseRepository repository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        employeeRepository.insertEmployee(new PartTimeEmployee("Jill", new BigDecimal("50")));
        employeeRepository.insertEmployee(new FullTimeEmployee("Jack", new BigDecimal("10000")));

        logger.info("Full Time Employees -> {}",
                employeeRepository.retrieveAllFullTimeEmployees());

        logger.info("Part Time Employees -> {}",
                employeeRepository.retrieveAllPartTimeEmployees());

        

//        List<Review> reviews=new ArrayList<>();
//        Review review1=new Review("5","oooooo");
//        Review review2=new Review("1", "naspa");
//        reviews.add(review1);
//        reviews.add(review2);
//      repository.addReviewsForCourse(10003L,reviews);



       // studentRepository.saveStudentWithPassport();


//        Course course=repository.findById(10001L);
//        logger.info("this is your course -> {}", course);
//
//        repository.deleteById(10001L);
//
//        repository.save(new Course("Microservice"));

    }
}
