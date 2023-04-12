package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Course;
import com.czq.back.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("update")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course savedCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @PostMapping("one")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable Long id) {
        Optional<Course> courseDTO = courseService.getCourseById(id);
        return ResponseEntity.ok(courseDTO);
    }

    @PostMapping("/del")
    public ResponseEntity<?> deleteCourse(@RequestBody QueryIdDTO queryIdDTO) {
        courseService.deleteCourse(queryIdDTO.getId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("list")
    public ListRet getAllCourses(@RequestBody PageDTO pageDTO) {
        final ListRet allCourses = courseService.getAllCourses(pageDTO);
        return allCourses;
    }

    // add other endpoints as needed
}
