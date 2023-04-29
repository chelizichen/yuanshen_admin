package com.czq.back.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "substitute")
public class Substitute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name="original_teacher_id")
    private String originTeacherId;

    @Column(name="substitute_teacher_id")
    private String substituteTeacherId;

    @Column(name="course_id")
    private String courseId;

    @ManyToOne
    @JoinColumn(name = "original_teacher_id",nullable = true,insertable=false ,updatable=false)
    private Teacher originalTeacher;

    @ManyToOne
    @JoinColumn(name = "substitute_teacher_id",nullable = true,insertable=false ,updatable=false)
    private Teacher newTeacher;

    @ManyToOne
    @JoinColumn(name = "course_id",nullable = true,insertable=false ,updatable=false)
    private Course course;

    @Column(name = "substitute_time")
    private LocalDateTime substituteTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getOriginalTeacher() {
        return originalTeacher;
    }

    public void setOriginalTeacher(Teacher originalTeacher) {
        this.originalTeacher = originalTeacher;
    }

    public Teacher getNewTeacher() {
        return newTeacher;
    }

    public void setNewTeacher(Teacher newTeacher) {
        this.newTeacher = newTeacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getSubstituteTime() {
        return substituteTime;
    }

    public void setSubstituteTime(LocalDateTime substituteTime) {
        this.substituteTime = substituteTime;
    }

    public String getOriginTeacherId() {
        return originTeacherId;
    }

    public void setOriginTeacherId(String originTeacherId) {
        this.originTeacherId = originTeacherId;
    }

    public String getSubstituteTeacherId() {
        return substituteTeacherId;
    }

    public void setSubstituteTeacherId(String substituteTeacherId) {
        this.substituteTeacherId = substituteTeacherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    // getters and setters
}
