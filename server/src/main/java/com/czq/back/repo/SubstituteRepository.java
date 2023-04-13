package com.czq.back.repo;

import com.czq.back.entity.Substitute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubstituteRepository extends JpaRepository<Substitute, Long> {

}
