package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Assignment;
import com.czq.back.entity.Course;
import com.czq.back.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public ListRet getAllCourses(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Course> byKeyword = courseRepository.findByKeyword(pageDTO.getKeyword(), pageable);
        List<Course> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            course.setId(id);
            return courseRepository.save(course);
        }
        return null;
    }

    public boolean deleteCourse(Long id) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
