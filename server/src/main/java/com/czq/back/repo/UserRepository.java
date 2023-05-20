package com.czq.back.repo;
import com.czq.back.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE  u.username = :username ")
    Optional<User> findByUsername(@Param("username") String username);

    @Query("SELECT a FROM  User a  WHERE a.username LIKE %?1%")
    Page<User> findByKeyword(String keyword, Pageable pageable);


}
