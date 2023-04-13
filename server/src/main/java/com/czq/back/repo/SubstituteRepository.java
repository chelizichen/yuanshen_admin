package com.czq.back.repo;

import com.czq.back.entity.Substitute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubstituteRepository extends JpaRepository<Substitute, Long> {
    @Query("SELECT a FROM  Substitute a  WHERE a.originalTeacher.name LIKE %?1%")
    Page<Substitute> findByKeyword(String keyword, Pageable pageable);
}
