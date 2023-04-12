package com.czq.back.repo;

import com.czq.back.entity.Assignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    @Query("SELECT a FROM  Assignment a  WHERE a.name LIKE %?1%")
    Page<Assignment> findByKeyword(String keyword, Pageable pageable);
}
