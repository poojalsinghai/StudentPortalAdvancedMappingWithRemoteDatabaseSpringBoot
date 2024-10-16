package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "enrollment_no")
    private String enrollmentNo;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private long phone;

    @ManyToOne
    @JoinColumn(name = "c_id", referencedColumnName = "id")
    private Course course; // Foreign key reference to Course

    // Getters and Setters
    public Student() {
    }

    public Student(String name, String enrollmentNo, String email, long phone, Course course) {
        this.name = name;
        this.enrollmentNo = enrollmentNo;
        this.email = email;
        this.phone = phone;
        this.course = course; // Assign course here
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enrollment_no='" + enrollmentNo + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", c_id=" + (course != null ? course.getId() : "No Course") +  // Access c_id here
                '}';
    }

}
