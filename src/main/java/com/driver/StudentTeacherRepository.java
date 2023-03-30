package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentTeacherRepository {
    static HashMap<String, List<String>> studentTeacherPairDb = new HashMap<>();

    static public String addStudentTeacherPair(String student, String teacher) {
        if(StudentRepository.studentDb.containsKey(student) && TeacherRepository.teacherDb.containsKey(teacher)) {

                List<String> students = studentTeacherPairDb.getOrDefault(teacher, new ArrayList<>());
                students.add(student);
                studentTeacherPairDb.put(teacher, students);

                return "New student-teacher pair added successfully";
        }

        return "";
    }

    static public List<String> getStudentsByTeacherName(String teacher) {
        if (studentTeacherPairDb.containsKey(teacher)) {
            return studentTeacherPairDb.get(teacher).stream().collect(Collectors.toList());
        }

        return null;
    }

    static public void deleteStudentTeacherPair(String teacher) {

        if (studentTeacherPairDb != null && studentTeacherPairDb.containsKey(teacher)) {

            List<String> students = studentTeacherPairDb.get(teacher);

            studentTeacherPairDb.remove(teacher);

            for (String student: students) {
                StudentRepository.deleteStudent(student);
            }
        }
    }
}
