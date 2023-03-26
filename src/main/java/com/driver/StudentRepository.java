package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentDb = new HashMap<>();

    public String addStudent(Student student) {
        String key = student.getName();

        studentDb.put(key, student);

        return "New student added successfully";
    }

    public List<Student> getAllStudents() {
        return studentDb.values().stream().collect(Collectors.toList());
    }

    public String deleteStudent(String name) {
        studentDb.remove(name);

        return " removed successfully";
    }
}
