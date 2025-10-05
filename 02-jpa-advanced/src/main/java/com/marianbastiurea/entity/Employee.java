package com.marianbastiurea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[%s] ", name);
    }
}
