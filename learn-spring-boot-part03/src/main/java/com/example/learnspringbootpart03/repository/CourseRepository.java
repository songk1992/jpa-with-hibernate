package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {
    EntityManager em;

    public CourseRepository(EntityManager em) {
        this.em = em;
    }

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

}
