package com.example.learnspringbootpart03;

import com.example.learnspringbootpart03.entity.*;
import com.example.learnspringbootpart03.repository.CourseRepository;
import com.example.learnspringbootpart03.repository.EmployeeRepository;
import com.example.learnspringbootpart03.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LearnSpringBootPart03Application implements CommandLineRunner {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private EmployeeRepository employeeRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LearnSpringBootPart03Application(CourseRepository courseRepository, StudentRepository studentRepository, EmployeeRepository employeeRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootPart03Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "Great Hands-on Stuff"));
//        reviews.add(new Review("5", "Great Hands-on Stuff"));
//        courseRepository.addReviewsForCourse(10001L, reviews);
//        studentRepository.inserStudentAndCourse(new Student("Jack"), new Course("MSA"));

        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));

        logger.info("{}", employeeRepository.retrieveAllEmployees());

    }
}
