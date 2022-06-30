package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.LearnSpringBootPart03Application;
import com.example.learnspringbootpart03.entity.Course;
import com.example.learnspringbootpart03.entity.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnSpringBootPart03Application.class)
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void findById() {
        Course course = repository.findById(10001L);
        assertEquals("인기강좌", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void saveCourse() {
        Course course = repository.findById(10002L);
        assertEquals("인기강좌2", course.getName());

        course.setName("Hello2");
        repository.save(course);

        Course course2 = repository.findById(10002L);
        assertEquals("Hello2", course2.getName());
    }

    @Test
    @DirtiesContext
    public void learnEntityManager() {
        repository.learnEntityManager();
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(10001L);
        logger.info("{}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class, 40001L);
        logger.info("{}", review.getCourse());
    }

    @Test
    @Transactional
    public void findById_firstLevelCacheDemo() {
        Course course = repository.findById(10001L);
        logger.info("First Course Retrieved {}", course);

        Course course1 = repository.findById(10001L);
        logger.info("First Course Retrieved Again {}", course1);

        assertEquals("인기강좌1", course.getName());
        assertEquals("인기강좌1", course1.getName());
    }
}