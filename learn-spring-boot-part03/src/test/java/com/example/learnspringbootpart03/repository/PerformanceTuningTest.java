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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnSpringBootPart03Application.class)
public class PerformanceTuningTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void creatingNPlusOneProblem() {
        List<Course> courses = em
                .createNamedQuery("q_get_all_courses", Course.class)
                .getResultList();
        for (Course course : courses){
            logger.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    public void solvingNPlusOneProblem_EntityGraph() {

        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        Subgraph<Object> subgraph = entityGraph.addSubgraph("students");

        List<Course> courses = em
                .createNamedQuery("q_get_all_courses", Course.class)
                .setHint("javax.persistence.loadgraph", entityGraph)
                .getResultList();
        for (Course course : courses){
            logger.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }
}