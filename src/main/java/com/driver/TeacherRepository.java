package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TeacherRepository {

    @Lazy
    @Autowired
    StudentTeacherRepository studentTeacherRepository;
    HashMap<String, Teacher> teacherDb = new HashMap<>();

    public String addTeacher(Teacher teacher) {
        String key = teacher.getName();

        teacherDb.put(key, teacher);

        return "New teacher added successfully";
    }

    public List<Teacher> getAllTeachers() {
//        if (teacherDb.isEmpty()) return new ArrayList<>();

        return teacherDb.values().stream().collect(Collectors.toList());
    }

    public String deleteTeacher(String name) {
        if (teacherDb.containsKey(name)) {
            teacherDb.remove(name);
            return studentTeacherRepository.deleteStudentTeacherPair(name);
        }

        return "";
    }
}
