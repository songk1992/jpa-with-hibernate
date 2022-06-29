package com.example.learnspringbootpart03.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee{

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    private BigDecimal salary;


}
