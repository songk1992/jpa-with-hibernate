package com.example.learnspringbootpart02;

import com.example.learnspringbootpart02.entity.Person;
import com.example.learnspringbootpart02.entity.PersonEntity;
import com.example.learnspringbootpart02.jdbc.PersonJdbcDao;
import com.example.learnspringbootpart02.jpa.PersonJpaRepository;
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

    PersonJpaRepository repository;

    public LearnSpringBootPart02Application(PersonJdbcDao dao, PersonJpaRepository repository) {
        this.dao = dao;
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootPart02Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        logger.info("All users -> {}", dao.findAll());
//        logger.info("User id 10001 -> {}", dao.findById(10001));
//        logger.info("User name SONG -> {}", dao.findByName("SONG"));
//        logger.info("Delete by id 10002 -> {}", dao.deleteById(10002));
//        logger.info("Insert person -> {}", dao.insertPerson(new Person(10005, "name", "location", new Date())));
//        logger.info("Update person -> {}", dao.updatePerson(new Person(10005, "name2", "location", new Date())));


        logger.info("User id 10001 -> {}", repository.insert(new PersonEntity( "name", "location", new Date())));
        logger.info("User id 10001 -> {}", repository.update(new PersonEntity( "name", "location", new Date())));
        logger.info("User id 10001 -> {}", repository.findById(10001));
        repository.deleteById(10001);
        logger.info("User id 10001 -> {}", repository.findById(10001));
        logger.info("All users -> {}", repository.findAll());
    }
}