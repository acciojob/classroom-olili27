package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

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
            List<String> students = studentTeacherPairDb.getOrDefault(teacher, null);
            students.add(student);
            studentTeacherPairDb.put(teacher, students);

            return "New student-teacher pair added successfully";
        }

        return "";
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentTeacherPairDb.get(teacher).stream().collect(Collectors.toList());
    }

    public String deleteStudentTeacherPair(String name) {
        List<String> students = studentTeacherPairDb.get(name);

        studentTeacherPairDb.remove(name);

        for (String student: students) {
            studentRepository.deleteStudent(student);
        }

        return " removed successfully";
    }
}
