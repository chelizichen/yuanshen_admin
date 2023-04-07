package com.czq.back.entity;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "course_id")
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "code", nullable = false)
        private String code;

        @Column(name = "description")
        private String description;

        @Column(name = "semester")
        private String semester;

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

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getSemester() {
                return semester;
        }

        public void setSemester(String semester) {
                this.semester = semester;
        }
}
