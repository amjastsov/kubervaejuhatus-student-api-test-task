package com.apitask.studentapi.controller;

import com.apitask.studentapi.dto.StudentCreateRequest;
import com.apitask.studentapi.dto.StudentUpdateRequest;
import com.apitask.studentapi.entity.Student;
import com.apitask.studentapi.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentCreateRequest request) {
        Student student = studentService.createStudent(request);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{studentNumber}")
    public ResponseEntity<Student> getStudent(@PathVariable String studentNumber) {
        Optional<Student> foundStudent = studentService.getStudent(studentNumber);
        return foundStudent.map(student
                -> ResponseEntity.status(HttpStatus.OK).body(student))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PatchMapping("/{studentNumber}")
    public ResponseEntity<Student> updateStudent(@PathVariable String studentNumber,
                                                 @RequestBody StudentUpdateRequest request) {
        Optional<Student> updatedStudent = studentService.updateStudent(studentNumber, request);
        return updatedStudent.map(student
                -> ResponseEntity.status(HttpStatus.OK).body(student))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{studentNumber}")
    public ResponseEntity<Student> deleteStudent(@PathVariable String studentNumber) {
        Optional<Student> deletedStudent = studentService.deleteStudent(studentNumber);
        return deletedStudent.map(student
                -> ResponseEntity.status(HttpStatus.OK).body(student))
                .orElseGet(
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
