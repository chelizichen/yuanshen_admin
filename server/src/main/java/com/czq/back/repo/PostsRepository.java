package com.czq.back.repo;
import com.czq.back.entity.Follows;
import com.czq.back.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {

    @Query("SELECT a FROM  Post a  WHERE a.title LIKE %?1%")
    Page<Post> findByKeyword(String keyword, Pageable pageable);

}
