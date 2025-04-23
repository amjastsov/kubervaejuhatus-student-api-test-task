package com.apitask.studentapi.service;

import com.apitask.studentapi.dto.StudentCreateRequest;
import com.apitask.studentapi.dto.StudentUpdateRequest;
import com.apitask.studentapi.entity.Student;
import com.apitask.studentapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(StudentCreateRequest request) {
        Student student = new Student(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getStudentNumber()
        );
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(String studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }

    public Optional<Student> updateStudent(String studentNumber, StudentUpdateRequest request) {
        Optional<Student> existingStudent = studentRepository.findByStudentNumber(studentNumber);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();

            if (request.getFirstName() != null) student.setFirstName(request.getFirstName());
            if (request.getLastName() != null) student.setLastName(request.getLastName());
            if (request.getEmail() != null) student.setEmail(request.getEmail());

            studentRepository.save(student);
            return Optional.of(student);
        }

        return Optional.empty();
    }

    public Optional<Student> deleteStudent(String studentNumber) {
        Optional<Student> deletedStudent = studentRepository.findByStudentNumber(studentNumber);

        if (studentRepository.existsByStudentNumber(studentNumber)) {
            studentRepository.deleteByStudentNumber(studentNumber);
        }

        return deletedStudent;
    }
}
