package com.example.learnspringbootpart03;

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
        logger.info(repository.findById(10001L).toString());
    }
}
