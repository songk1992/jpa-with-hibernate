package com.example.learnspringbootpart02.jdbc;

import com.example.learnspringbootpart02.entity.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    JdbcTemplate jdbcTemplate;

    public PersonJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    // select one person by id
    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class));
    }

    // select one person by name
    public Person findByName(String name) {
        return jdbcTemplate.queryForObject("select * from person where name=?",
                new Object[]{name},
                new BeanPropertyRowMapper<>(Person.class));
    }

    // delete one person by id
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }

    // insert one person
    public int insertPerson(Person person) {
        return jdbcTemplate.update("INSERT INTO PERSON\n" +
                "(ID, NAME, LOCATION, BIRTH_DATE)\n" +
                "VALUES(?, ?, ?, ?);", new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthdate().getTime())});
    }

    // update one person
    public int updatePerson(Person person) {
        return jdbcTemplate.update("update PERSON " +
                "set name= ?, location=?, birth_date=? where id= ?",
                new Object[]{person.getName(), person.getLocation(),
                        new Timestamp(person.getBirthdate().getTime()), person.getId()});
    }
}
