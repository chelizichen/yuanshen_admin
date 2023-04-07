package com.czq.back.repo;
import com.czq.back.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
}
