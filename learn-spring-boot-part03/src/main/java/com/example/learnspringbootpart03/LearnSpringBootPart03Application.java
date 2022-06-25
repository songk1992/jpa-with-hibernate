package com.example.learnspringbootpart03;

import com.example.learnspringbootpart03.repository.CourseRepository;
import com.example.learnspringbootpart03.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootPart03Application implements CommandLineRunner {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LearnSpringBootPart03Application(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootPart03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepository.saveStudentWithPassport();
    }
}
