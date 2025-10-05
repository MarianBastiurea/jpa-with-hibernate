package com.marianbastiurea.repository;

import com.marianbastiurea.JpaApplication;
import com.marianbastiurea.entity.Course;
import jakarta.persistence.EntityManager;
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

}
