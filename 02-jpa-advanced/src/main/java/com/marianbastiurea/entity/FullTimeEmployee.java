package com.marianbastiurea.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee{

    protected FullTimeEmployee(){}

    private BigDecimal salary;

    public FullTimeEmployee(String name, BigDecimal salary){
        super(name);
        this.salary = salary;
    }
}
