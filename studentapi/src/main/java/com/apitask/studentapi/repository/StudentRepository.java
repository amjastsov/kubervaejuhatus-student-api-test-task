package com.apitask.studentapi.repository;

import com.apitask.studentapi.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    private final Map<String, Student> students = new HashMap<>();

    public Student save(Student student) {
        students.put(student.getStudentNumber(), student);
        return student;
    }

    public Optional<Student> findByStudentNumber(String studentNumber) {
        return Optional.ofNullable(students.get(studentNumber));
    }

    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    public void deleteByStudentNumber(String studentNumber) {
        students.remove(studentNumber);
    }

    public boolean existsByStudentNumber(String studentNumber) {
        return students.containsKey(studentNumber);
    }
}
