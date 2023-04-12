package com.czq.back.repo;

import com.czq.back.entity.Assignment;
import com.czq.back.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT a FROM  Course a  WHERE a.name LIKE %?1%")
    Page<Course> findByKeyword(String keyword, Pageable pageable);
}
