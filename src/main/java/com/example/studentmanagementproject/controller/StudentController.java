package com.example.studentmanagementproject.controller;

import com.example.studentmanagementproject.model.Student;
import com.example.studentmanagementproject.repository.StudentRepository;
import com.example.studentmanagementproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;


    // api List students
    @GetMapping("/students")
    public String getListStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student";
        //api add students
    }
        @GetMapping("/students/new")
         public String addStudents (Model model){
            Student student = new Student();
            model.addAttribute("student", student);
            return "create_student";
        }
        // api create new Student

    @PostMapping("/students")
    public String createNewStudent(@ModelAttribute ("student") Student student){

         studentService.save(student);
         return "redirect:/student";

    }

    // api edit student

    @GetMapping("/students/edit/{id}")
    public String getToEditStudent (@PathVariable int id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    // api edit student

    @PostMapping("/students/{id}")
    public String updateNewStudent(@PathVariable int id,
                                 @ModelAttribute("student") Student student) {
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        studentService.saveUpdateStudent(student);
        return "redirect:/student";
    }

    //api delete student
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return"redirect:/student";
    }
}
