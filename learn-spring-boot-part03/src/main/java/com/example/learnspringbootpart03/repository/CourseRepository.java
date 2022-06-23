package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {
    EntityManager em;

    public CourseRepository(EntityManager em) {
        this.em = em;
    }

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }


    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

}
