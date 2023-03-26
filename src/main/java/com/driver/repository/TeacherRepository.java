package com.driver.repository;

import com.driver.models.Student;
import com.driver.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

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
        return teacherDb.values().stream().collect(Collectors.toList());
    }

    public String deleteTeacher(String name) {
        teacherDb.remove(name);

        String msg = studentTeacherRepository.deleteStudentTeacherPair(name);

        return msg;
    }
}
