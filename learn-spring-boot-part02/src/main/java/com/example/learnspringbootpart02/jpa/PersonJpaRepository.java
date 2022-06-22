package com.example.learnspringbootpart02.jpa;

import com.example.learnspringbootpart02.entity.PersonEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    // connect to the database
    @PersistenceContext
    EntityManager entityManager;

    public List<PersonEntity> findAll(){
        TypedQuery<PersonEntity> namedQuery = entityManager.createNamedQuery("find_all_persons", PersonEntity.class);
        return namedQuery.getResultList();
    }

    public PersonEntity findById(int id){
        return entityManager.find(PersonEntity.class, id);
    }

    public PersonEntity update(PersonEntity person){
        return entityManager.merge(person);
    }

    public PersonEntity insert(PersonEntity person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        PersonEntity person = findById(id);
        entityManager.remove(person);
    }
}
