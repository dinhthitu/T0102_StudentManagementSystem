package com.example.studentmanagementproject.service;

import com.example.studentmanagementproject.model.Student;
import com.example.studentmanagementproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public Student save(Student student) {
       return studentRepository.save(student);
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public Student saveUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
