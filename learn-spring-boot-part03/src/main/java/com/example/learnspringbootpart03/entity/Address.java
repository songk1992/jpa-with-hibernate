package com.example.learnspringbootpart03.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String line1;
    private String line2;
    private String line3;
    private String city;

    public Address(String line1, String line2, String line3, String city) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.city = city;
    }

    public Address() {
    }
}
