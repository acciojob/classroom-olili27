package com.driver;

import java.util.List;

import com.driver.Teacher;
import com.driver.Student;
import com.driver.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        String reponse = studentService.addTeacher(teacher);

        return new ResponseEntity<>(reponse, HttpStatus.CREATED);
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher){
        String response = studentService.addStudentTeacherPair(student, teacher);

        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
        Student student = studentService.getStudentByName(name); // Assign student by calling service layer method

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = studentService.getTeacherByName(name); // Assign student by calling service layer method

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = studentService.getStudentsByTeacherName(teacher); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = studentService.getAllStudents(); // Assign list of student by calling service layer method

        return new ResponseEntity<>(students, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        String response = studentService.deleteTeacherByName(teacher);
        return new ResponseEntity<>(teacher + " " +  response, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers(){
        String response = studentService.deleteAllTeachers();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
