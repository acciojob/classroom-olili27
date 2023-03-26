package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {
    @Lazy
    @Autowired
    StudentRepository studentRepository;

    @Lazy
    @Autowired
    StudentTeacherRepository studentTeacherRepository;

    @Lazy
    @Autowired
    TeacherRepository teacherRepository;

    public String addStudent(Student student) {
       String res = studentRepository.addStudent(student);

       return res;
    }

    public String addTeacher(Teacher teacher) {
        String res = teacherRepository.addTeacher(teacher);

        return res;
    }

    public String addStudentTeacherPair(String student, String teacher) {
        String res = studentTeacherRepository.addStudentTeacherPair(student, teacher);

        return res;
    }

    public Student getStudentByName(String name) {
        List<Student> students = studentRepository.getAllStudents();

        for (Student student: students) {
            if(student.getName().equals(name)) {
                return student;
            }
        }

        return null;
    }

    public Teacher getTeacherByName(String name) {
        List<Teacher> teachers = teacherRepository.getAllTeachers();

        for (Teacher teacher: teachers) {
            if(teacher.getName().equals(name)) {
                return teacher;
            }
        }

        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<String> students = studentTeacherRepository.getStudentsByTeacherName(teacher);

        return students;
    }

    public List<String> getAllStudents() {
        List<Student> studentList = studentRepository.getAllStudents();
        List<String> studentNames = new ArrayList<>();

        for (Student student: studentList) {
            studentNames.add(student.getName());
        }

        return studentNames;
    }

    public String deleteTeacherByName(String teacher) {
        String msg = teacherRepository.deleteTeacher(teacher);

        return msg;
    }

    public String deleteAllTeachers() {
        List<Teacher> teachers = teacherRepository.getAllTeachers();

        for (Teacher teacher: teachers) {
            deleteTeacherByName(teacher.getName());
        }

        return "All teachers deleted successfully";
    }
}
