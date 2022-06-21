package com.example.learnspringbootpart02;

import com.example.learnspringbootpart02.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootPart02Application  implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    PersonJdbcDao dao;

    public LearnSpringBootPart02Application(PersonJdbcDao dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootPart02Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}", dao.findAll());

    }
}
