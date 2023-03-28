package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        if (studentDb.isEmpty()) return null;

        return studentDb.values().stream().collect(Collectors.toList());
    }

    public String deleteStudent(String name) {
        if (studentDb.containsKey(name)) {
            studentDb.remove(name);

            return " removed successfully";
        }
        return "";
    }

    // TEACHER SECTION
    HashMap<String, Teacher> teacherDb = new HashMap<>();

    public String addTeacher(Teacher teacher) {
        String key = teacher.getName();

        teacherDb.put(key, teacher);

        return "New teacher added successfully";
    }

    public List<Teacher> getAllTeachers() {
        if (teacherDb.isEmpty()) return null;

        return teacherDb.values().stream().collect(Collectors.toList());
    }

    public String deleteTeacher(String name) {
        if (teacherDb.containsKey(name)) {
            teacherDb.remove(name);
            return deleteStudentTeacherPair(name);
        }

        return "";
    }

    // STUDENT TEACHER PAIR SECTION

    HashMap<String, List<String>> studentTeacherPairDb = new HashMap<>();

    public String addStudentTeacherPair(String student, String teacher) {
        if(studentDb.containsKey(student) && teacherDb.containsKey(teacher)) {

            if (studentTeacherPairDb.containsKey(teacher)) {
                List<String> oldList = studentTeacherPairDb.get(teacher);
                oldList.add(student);
                studentTeacherPairDb.put(teacher, oldList);

                return "New student-teacher pair added successfully";
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(student);
                studentTeacherPairDb.put(teacher, newList);

                return "New student-teacher pair added successfully";
            }
        }

        return "";
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        if (!studentTeacherPairDb.containsKey(teacher)) return null;

        return studentTeacherPairDb.get(teacher).stream().collect(Collectors.toList());
    }

    public String deleteStudentTeacherPair(String teacher) {

        if (!studentTeacherPairDb.containsKey(teacher)) return "";

        List<String> students = studentTeacherPairDb.get(teacher);

        studentTeacherPairDb.remove(teacher);

        for (String student: students) {
            deleteStudent(student);
        }

        return " removed successfully";
    }
}
