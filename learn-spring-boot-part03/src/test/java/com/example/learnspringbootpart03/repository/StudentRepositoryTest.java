package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.LearnSpringBootPart03Application;
import com.example.learnspringbootpart03.entity.Address;
import com.example.learnspringbootpart03.entity.Passport;
import com.example.learnspringbootpart03.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnSpringBootPart03Application.class)
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void retrieveStudentAndPasswordDetails() {
        Student student = em.find(Student.class, 30001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    public void someTest() {
        repository.someOperationToUnderstandPersistence();
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 20001L);
        logger.info("passport -> {}", passport);
        logger.info("passport -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourses() {
        Student student = em.find(Student.class,  30001L);
        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }

    @Test
    @Transactional
    void setAddressDetails() {
        Student student = em.find(Student.class, 30001L);
        student.setAddress(new Address("No 101", "1", "2", "hey"));
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

}