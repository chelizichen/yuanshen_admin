package com.czq.back.repo;
import com.czq.back.entity.Student;
import com.czq.back.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("SELECT u FROM Teacher u WHERE  u.phone = ?1 ")
    Optional<Teacher> findByPhone(String phone);

    @Query("SELECT a FROM  Teacher a  WHERE a.name LIKE %?1% and a.permission = '1'")
    Page<Teacher> findByKeyword(String keyword, Pageable pageable);

    @Query("SELECT a FROM  Teacher a  WHERE a.name LIKE %?1%")
    Page<Teacher> AdminFindByKeyword(String keyword, Pageable pageable);

    @Query("SELECT a FROM  Teacher a  WHERE a.titleId = ?1")
    List<Teacher> findTeacherByTitle(Integer title);

    @Query("update Teacher t set t.titleId = ?1 where t.id = ?2")
    Integer SetTitle(Integer titleId,Integer id);

}
