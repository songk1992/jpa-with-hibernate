package com.example.learnspringbootpart03.repository;

import com.example.learnspringbootpart03.entity.Passport;
import com.example.learnspringbootpart03.entity.Student;
import com.example.learnspringbootpart03.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {
    EntityManager em;

    public StudentRepository(EntityManager em) {
        this.em = em;
    }

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }


    public void deleteById(Long id){
        Student student = findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("Z12345");
        em.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }

    @Transactional
    public void someOperationToUnderstandPersistence() {
        // DB Operation 1 - Retrieve student
        Student student = em.find(Student.class, 30001L);
        // Persistence Context(student)

        // DB Operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        // Persistence Context(student, passport)

        // DB Operation 3 - update student
        student.setName("KIMC - updated");
        // Persistence Context(student++, passport)

        // DB Operation 4 - update passport
        passport.setNumber("여권번호 123");
        // Persistence Context(student, passport++)

    }

}
