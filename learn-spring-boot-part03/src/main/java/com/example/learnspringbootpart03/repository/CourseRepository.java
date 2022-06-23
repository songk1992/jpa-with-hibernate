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

    public Course save(Course course){
        if(course.getId() == null){
            em.persist(course);
        } else{
            em.merge(course);
        }
        return course;
    }

    // transaction 내부에 persist 를 호출하면
    // entity 들을 1차 캐시에 저장하고, 논리적으로 DB 저장소에 넣기 전에 persist context에 넣고 기다린 다음
    // transaction이 끝나면 동시에 DB에 쿼리를 보내고
    // flush() 라고 한다.
    public void learnEntityManager(){
        Course course = new Course("new course");
        em.persist(course);
        course.setName("new Course - updated");
    }

}
