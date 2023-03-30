package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    public String addStudent(Student student) {
       return  StudentRepository.addStudent(student);
    }

    public String addTeacher(Teacher teacher) {
        return TeacherRepository.addTeacher(teacher);
    }

    public String addStudentTeacherPair(String student, String teacher) {
        return StudentTeacherRepository.addStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String name) {
        List<Student> students = StudentRepository.getAllStudents();

        if (students != null) {
            for (Student student: students) {
                if(student.getName().equals(name)) {
                    return student;
                }
            }
        }

        return null;
    }

    public Teacher getTeacherByName(String name) {
        List<Teacher> teachers = TeacherRepository.getAllTeachers();

        if (teachers != null) {
            for (Teacher teacher : teachers) {
                if (teacher.getName().equals(name)) {
                    return teacher;
                }
            }
        }

        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> students = StudentTeacherRepository.getStudentsByTeacherName(teacher);

        if (students == null) return null;

        return students;
    }

    public List<String> getAllStudents() {
        List<Student> studentList = StudentRepository.getAllStudents();

        if (studentList == null) return null;

        List<String> studentNames = new ArrayList<>();

        for (Student student: studentList) {
            studentNames.add(student.getName());
        }

        return studentNames;
    }

    public String deleteTeacherByName(String teacher) {
        return TeacherRepository.deleteTeacher(teacher);
    }

    public String deleteAllTeachers() {
        List<Teacher> teachers = TeacherRepository.getAllTeachers();

        if (teachers == null) return "";

        for (Teacher teacher: teachers) {
            deleteTeacherByName(teacher.getName());
        }

        return "All teachers deleted successfully";
    }
}
