package com.czq.back.service;

import com.czq.back.entity.Attendance;
import com.czq.back.repo.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
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
