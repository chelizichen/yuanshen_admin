package com.czq.back.repo;
import com.czq.back.entity.Assignment;
import com.czq.back.entity.Research;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ResearchRepository extends JpaRepository<Research, Long> {
    @Query("SELECT a FROM  Research a  WHERE a.researchTopic LIKE %?1%")
    Page<Research> findByKeyword(String keyword, Pageable pageable);

}
