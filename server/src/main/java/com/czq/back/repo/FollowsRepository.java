package com.czq.back.repo;
import com.czq.back.entity.Follows;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowsRepository extends JpaRepository<Follows, Long> {

    @Query("SELECT a FROM  Follows a  WHERE a.content LIKE %?1%")
    Page<Follows> findByKeyword(String keyword, Pageable pageable);

}
