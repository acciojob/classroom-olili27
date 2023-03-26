package com.driver.models;

public class Student {

    private String name;
    private int age;
    private double averageScore;

    public Student(String name, int age, double averageScore){
        this.age = age;
        this.averageScore = averageScore;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public double getAverageScore() {
        return averageScore;
    }
}
