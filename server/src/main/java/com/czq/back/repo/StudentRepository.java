package com.czq.back.repo;
import com.czq.back.entity.Assignment;
import com.czq.back.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT a FROM  Student a  WHERE a.name LIKE %?1%")
    Page<Student> findByKeyword(String keyword, Pageable pageable);
}
