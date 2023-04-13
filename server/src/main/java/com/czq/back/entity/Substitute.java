package com.czq.back.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "substitute")
public class Substitute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "original_teacher_id")
    private Teacher originalTeacher;

    @ManyToOne
    @JoinColumn(name = "substitute_teacher_id")
    private Teacher newTeacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "substitute_time")
    private LocalDateTime substituteTime;

    // getters and setters
}
