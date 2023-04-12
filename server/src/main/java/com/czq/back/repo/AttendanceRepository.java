package com.czq.back.repo;

import com.czq.back.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("select a from Attendance a where a.teacherId = ?1 ")
    List<Attendance> findByTeacherId(Long teacherId);
}
