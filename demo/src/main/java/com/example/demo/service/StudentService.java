package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<String> getStudentNamesByCourseName(String cName) {

        return studentRepository.findStudentNamesByCourseName(cName);
    }

    public void updateStudentCourseId(int studentId, int courseId) {
        studentRepository.updateStudentCourseId(studentId, courseId);
    }
}
