package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentTeacherRepository {

    @Lazy
    @Autowired
    StudentRepository studentRepository;

    @Lazy
    @Autowired
    TeacherRepository teacherRepository;
    HashMap<String, List<String>> studentTeacherPairDb = new HashMap<>();

    public String addStudentTeacherPair(String student, String teacher) {
        if(studentRepository.studentDb.containsKey(student) && teacherRepository.teacherDb.containsKey(teacher)) {

            if (studentTeacherPairDb.containsKey(teacher)) {
                List<String> oldList = studentTeacherPairDb.get(teacher);
                oldList.add(student);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(student);
            }

            return "New student-teacher pair added successfully";
        }

        return "";
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        if (!studentTeacherPairDb.containsKey(teacher)) return new ArrayList<>();

        return studentTeacherPairDb.get(teacher).stream().collect(Collectors.toList());
    }

    public String deleteStudentTeacherPair(String teacher) {

        if (!studentTeacherPairDb.containsKey(teacher)) return "";

        List<String> students = studentTeacherPairDb.get(teacher);

        studentTeacherPairDb.remove(teacher);

        for (String student: students) {
            studentRepository.deleteStudent(student);
        }

        return " removed successfully";
    }
}
