package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.entity.Course;
import com.example.learnspringbootpart03.entity.Review;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

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


    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    // transaction 내부에 persist 를 호출하면
    // entity 들을 1차 캐시에 저장하고, 논리적으로 DB 저장소에 넣기 전에 persist context에 넣고 기다린 다음
    // transaction이 끝나면 동시에 DB에 쿼리를 보내고
    // flush() 라고 한다.
    public void learnEntityManager() {
        Course course = new Course("new course");
        em.persist(course);
        course.setName("new Course - updated");
    }

    // detach 이후 course 2 에 의해서 업데이트 되는 내용은 DB로 보내지지 않음
    public void learnEntityManager02() {
        Course course1 = new Course("new course");
        em.persist(course1);
        em.flush();

        course1.setName("new Course - updated");
        em.flush();

        Course course2 = new Course("new course 2");
        em.persist(course2);
        em.flush();

        em.detach(course2); // DB 보내기전의 설정된 데이트를 track 화지 않음
        em.clear(); // DB 보내기 전의 모든 데이터를 clear 함

        course2.setName("new Course 2 - updated");
        em.flush();
    }

    // refresh 로 연관된 데이터를 다시 불러와서 새로고침한다
    public void learnEntityManager03() {
        Course course1 = new Course("new course");
        em.persist(course1);
        Course course2 = new Course("new course 2");
        em.persist(course2);
        em.flush();

        course1.setName("new Course - updated");
        course2.setName("new Course 2 - updated");

        em.refresh(course1);
        em.flush();
    }

    public void learnEntityManager04() {
        Course course1 = new Course("new course");
        em.persist(course1);
        Course course2 = new Course("new course 2");
        course2.setName("new Course 2 - updated");
    }

    public void addHardCodedReviewsForCourse() {
        // get the course 10003
        Course course = findById(10001L);

        // add 2 reviews to it
        Review review1 = new Review("5", "Great Hands-on Stuff");
        Review review2 = new Review("5", "Great Hands-on Stuff");

        course.addReviews(review1);
        review1.setCourse(course);

        course.addReviews(review2);
        review2.setCourse(course);

        // save it to the database
        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(10001L);

        reviews.forEach(r -> {
            course.addReviews(r);
            r.setCourse(course);
            em.persist(r);
        });

    }
}
