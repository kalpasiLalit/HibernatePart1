package com.SpringJpaHibernatePart1.hibernatePart1.Entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    private String name;
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  int age;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

