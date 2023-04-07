package com.czq.back.repo;
import com.czq.back.entity.Research;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ResearchRepository extends JpaRepository<Research, Long> {
}
