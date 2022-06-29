package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.LearnSpringBootPart03Application;
import com.example.learnspringbootpart03.entity.Course;
import com.example.learnspringbootpart03.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnSpringBootPart03Application.class)
public class JPQLTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void findById(){
        List resultList = em.createNamedQuery("q_get_all_courses").getResultList();
        logger.info("select c from Course c -> {}", resultList);
    }

    @Test
    public void findById_jpql_typed(){
        TypedQuery<Course> query = em.createNamedQuery("q_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("select c from Course c -> {}", resultList);
    }

    @Test
    public void findById_jpql_where(){
        TypedQuery<Course> query = em.createNamedQuery("q_get_like_he_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("select c from Course c -> {}", resultList);
    }

    @Test
    public void jpql_courses_without_students(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_with_atleast_2_students(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) > 2", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_student_with_certain_passport(){
        TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%여권%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("Student -> {}", resultList);
    }
}
