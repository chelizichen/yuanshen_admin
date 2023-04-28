package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Attendance;
import com.czq.back.entity.Section;
import com.czq.back.repo.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public ListRet getAllAttendanceByTeacher(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Attendance> byKeyword = attendanceRepository.findByKeywordByTeacher(pageDTO.getKeyword(), pageable);
        List<Attendance> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public ListRet getAllAttendanceByStudent(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Attendance> byKeyword = attendanceRepository.findByKeywordByStudent(pageDTO.getKeyword(), pageable);
        List<Attendance> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {
        Optional<Attendance> existingAttendance = attendanceRepository.findById(id);
        if (existingAttendance.isPresent()) {
            attendance.setId(id);
            return attendanceRepository.save(attendance);
        }
        return null;
    }

    public boolean deleteAttendance(Long id) {
        Optional<Attendance> existingAttendance = attendanceRepository.findById(id);
        if (existingAttendance.isPresent()) {
            attendanceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void markAttendance( Attendance attendanceDTO) {
        attendanceRepository.save(attendanceDTO);
    }

    public List<Attendance> getAttendanceByTeacherId(Long teacherId) {
        return attendanceRepository.findByTeacherId(teacherId);
    }

}
