package com.driver;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherRepository {
    static HashMap<String, Teacher> teacherDb = new HashMap<>();

    static public String addTeacher(Teacher teacher) {
        String key = teacher.getName();

        teacherDb.put(key, teacher);

        return "New teacher added successfully";
    }

    static public List<Teacher> getAllTeachers() {
        if (teacherDb == null) return null;

        return teacherDb.values().stream().collect(Collectors.toList());
    }

    static public String  deleteTeacher(String name) {
        if (teacherDb != null && teacherDb.containsKey(name)) {
            teacherDb.remove(name);
            StudentTeacherRepository.deleteStudentTeacherPair(name);

            return "Deleted successfully";
        }

        return "";
    }
}
