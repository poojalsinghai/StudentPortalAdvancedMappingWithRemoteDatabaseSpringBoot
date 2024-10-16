package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // I have used a custom JPQL query to perform this set of actions which JPA cannot automatically do
    @Query("SELECT s.name FROM Student s JOIN s.course c WHERE c.name = :courseName")
    List<String> findStudentNamesByCourseName(@Param("courseName") String courseName);
}
