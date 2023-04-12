package com.czq.back.entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Attendance")
// 考勤表
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    // 考勤日期
    @Column(name = "date", nullable = false)
    private Date date;

    // 是否在场
    @Column(name = "present", nullable = false)
    private Boolean present;

    @Column(name = "teacher_id", nullable = false)
    private Boolean teacherId;

    // 学生ID
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    // 科目ID
    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    private Section section;

    // Constructors, getters, and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Boolean getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Boolean teacherId) {
        this.teacherId = teacherId;
    }
}

