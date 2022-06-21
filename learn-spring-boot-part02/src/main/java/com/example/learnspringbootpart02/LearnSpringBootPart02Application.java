package com.example.learnspringbootpart02;

import com.example.learnspringbootpart02.entity.Person;
import com.example.learnspringbootpart02.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

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
        logger.info("User id 10001 -> {}", dao.findById(10001));
        logger.info("User name SONG -> {}", dao.findByName("SONG"));
        logger.info("Delete by id 10002 -> {}", dao.deleteById(10002));
        logger.info("Insert person -> {}", dao.insertPerson(new Person(10005, "name", "location", new Date())));
        logger.info("Update person -> {}", dao.updatePerson(new Person(10005, "name2", "location", new Date())));
    }
}