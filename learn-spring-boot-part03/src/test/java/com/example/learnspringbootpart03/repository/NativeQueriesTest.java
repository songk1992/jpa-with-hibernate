package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.LearnSpringBootPart03Application;
import com.example.learnspringbootpart03.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnSpringBootPart03Application.class)
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void native_queries_with_parameter(){
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = ?", Course.class);
        query.setParameter(1, 10001L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE WHRER ID = ? -> {}", resultList);
    }

    @Test
    public void native_queries_with_named_parameter(){
        Query query = em.createNativeQuery("SELECT * FROM COURSE WHERE id = :id", Course.class);
        query.setParameter("id", 10003L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM COURSE WHRER ID = = :id -> {}", resultList);
    }
}
