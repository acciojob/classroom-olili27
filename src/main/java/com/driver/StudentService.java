package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
       String res = studentRepository.addStudent(student);

       return res;
    }

    public String addTeacher(Teacher teacher) {
        String res = studentRepository.addTeacher(teacher);

        return res;
    }

    public String addStudentTeacherPair(String student, String teacher) {
        String res = studentRepository.addStudentTeacherPair(student, teacher);

        return res;
    }

    public Student getStudentByName(String name) {
        List<Student> students = studentRepository.getAllStudents();

        if (students.size() > 0) {
            for (Student student: students) {
                if(student.getName().equals(name)) {
                    return student;
                }
            }
        }

        return null;
    }

    public Teacher getTeacherByName(String name) {
        List<Teacher> teachers = studentRepository.getAllTeachers();

        if (teachers !=) {
            for (Teacher teacher : teachers) {
                if (teacher.getName().equals(name)) {
                    return teacher;
                }
            }
        }

        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> students = studentRepository.getStudentsByTeacherName(teacher);

        if (students == null) return null;

        return students;
    }

    public List<String> getAllStudents() {
        List<Student> studentList = studentRepository.getAllStudents();

        if (studentList == null) return null;

        List<String> studentNames = new ArrayList<>();

        for (Student student: studentList) {
            studentNames.add(student.getName());
        }

        return studentNames;
    }

    public String deleteTeacherByName(String teacher) {
        String msg = studentRepository.deleteTeacher(teacher);

        return msg;
    }

    public String deleteAllTeachers() {
        List<Teacher> teachers = studentRepository.getAllTeachers();

        if (teachers == null) return "";

        for (Teacher teacher: teachers) {
            deleteTeacherByName(teacher.getName());
        }

        return "All teachers deleted successfully";
    }
}
