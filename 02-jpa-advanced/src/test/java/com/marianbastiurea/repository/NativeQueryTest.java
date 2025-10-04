package com.marianbastiurea.repository;


import com.marianbastiurea.JpaApplication;
import com.marianbastiurea.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
public class NativeQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Test
    public void native_query_basics() {
        Query query = entityManager.createNativeQuery("SELECT * FROM COURSE where id=?", Course.class);
        query.setParameter(1, 1000L);
        List resultList = query.getResultList();
        logger.info("Select c From Course c->{}", resultList);
    }

}
