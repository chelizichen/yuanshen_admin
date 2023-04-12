package com.czq.back.entity;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Assignment")
// 期末作业
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "max_points")
    private String maxPoints;

    @ManyToOne
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    private Section section;

    public String getMaxPoints() {
        return maxPoints;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setMaxPoints(String maxPoints) {
        this.maxPoints = maxPoints;
    }

    // constructors, getters, and setters

    public Assignment() {
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


}
