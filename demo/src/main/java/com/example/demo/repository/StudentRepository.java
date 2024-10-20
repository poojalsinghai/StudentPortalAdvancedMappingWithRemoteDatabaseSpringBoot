package com.example.demo.repository;

import com.example.demo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // I have used a custom JPQL query to perform this set of actions which JPA cannot automatically do
    @Query("SELECT s.name FROM Student s WHERE s.course.name = :coName")
    List<String> findStudentNamesByCourseName(@Param("coName") String courseN);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.course.id = :courseId WHERE s.id = :studentId")
    void updateStudentCourseId(@Param("studentId") int studentId, @Param("courseId") int courseId);

}
