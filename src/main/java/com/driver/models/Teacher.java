package com.driver.models;

public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public Teacher(String name, int age, int numberOfStudents) {
        this.age = age;
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}