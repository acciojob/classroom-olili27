package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    static HashMap<String, Student> studentDb = new HashMap<>();

    static public String addStudent(Student student) {
        String key = student.getName();

        studentDb.put(key, student);

        return "New student added successfully";
    }

    static public List<Student> getAllStudents() {
        if (studentDb == null) return null;

        return studentDb.values().stream().collect(Collectors.toList());
    }

    static public void deleteStudent(String name) {
        if (studentDb != null && studentDb.containsKey(name)) {
            studentDb.remove(name);
        }
    }
}
