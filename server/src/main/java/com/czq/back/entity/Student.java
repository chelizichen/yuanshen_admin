package com.czq.back.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
// 学生表
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    // 学生姓名
    @Column(name = "name", nullable = false)
    private String name;

    // 邮箱
    @Column(name = "email", nullable = false)
    private String email;

    // 注册日期
    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    // constructors, getters, and setters

    public Student() {
    }

    public Student(String name, String email, LocalDate enrollmentDate) {
        this.name = name;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }


}
