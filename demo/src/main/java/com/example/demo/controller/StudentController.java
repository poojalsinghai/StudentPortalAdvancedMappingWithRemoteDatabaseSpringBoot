package com.example.demo.controller;

import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

//    @GetMapping("/by-course")
//    public List<String> getStudentsByCourse(@RequestParam String courseName) {
//        return studentService.getStudentNamesByCourseName(courseName);
//    }

    // Using Path Variable
    @GetMapping("/courseName/{courseName}")
    public List<String> getStudentsByCourse(@PathVariable String courseName) {
        return studentService.getStudentNamesByCourseName(courseName);
    }
}

