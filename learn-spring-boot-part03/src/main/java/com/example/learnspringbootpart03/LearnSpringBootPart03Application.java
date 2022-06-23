package com.example.learnspringbootpart03;

import com.example.learnspringbootpart03.entity.Course;
import com.example.learnspringbootpart03.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootPart03Application implements CommandLineRunner {

    private CourseRepository repository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public LearnSpringBootPart03Application(CourseRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootPart03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // select 10001
        logger.info(repository.findById(10001L).toString());

        // delete 10001
        repository.deleteById(10001L);

        // save 1
        repository.save(new Course("how to say hello"));

        Course course = new Course("how to say hello2");
        course.setId(1L);
        repository.save(course);

        // entity manager
        repository.learnEntityManager02();
    }
}
