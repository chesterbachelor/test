package org.example.brewery.employee;

public abstract class Employee {

    protected String name;
    protected int yearsOfExperience;

    protected Employee (String name, int yearsOfExperience){
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }
}
