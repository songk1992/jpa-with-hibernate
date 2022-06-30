package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.LearnSpringBootPart03Application;
import com.example.learnspringbootpart03.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnSpringBootPart03Application.class)
public class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(10001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void saveCourse() {
        Course course = new Course("Hello");
        repository.save(course);
        course.setName("Hello-updated");
        repository.save(course);
    }

    @Test
    public void findAllCourses() {
        logger.info("Courses -> {}", repository.findAll());
        logger.info("Count -> {}", repository.count());
    }

    @Test
    public void sort() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        logger.info("Courses -> {}", repository.findAll(sort));
        logger.info("Count -> {}", repository.count());
    }

    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<Course> firstPage = repository.findAll(pageRequest);
        logger.info("First Page -> {}", firstPage.getContent());
    }
}
