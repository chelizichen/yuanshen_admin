package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Attendance;
import com.czq.back.entity.Research;
import com.czq.back.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public ResponseEntity<?> markAttendance(@RequestBody Attendance attendanceDTO) {
        attendanceService.markAttendance(attendanceDTO);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/get/teacher")
    public ResponseEntity<List<Attendance>> getAttendanceByTeacherId(@RequestBody QueryIdDTO queryIdDTO) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByTeacherId(queryIdDTO.getId());
        return ResponseEntity.ok(attendanceList);
    }

    @PostMapping("teacher/list")
    public ListRet getAllAttendanceByTeacher(@RequestBody PageDTO pageDTO) {
        pageDTO.setPage(pageDTO.getPage()-1);
        final ListRet allAttendances = attendanceService.getAllAttendanceByTeacher(pageDTO);
        return allAttendances;
    }

    @PostMapping("student/list")
    public ListRet getAllAttendanceByStudent(@RequestBody PageDTO pageDTO) {
        pageDTO.setPage(pageDTO.getPage()-1);
        final ListRet allAttendances = attendanceService.getAllAttendanceByStudent(pageDTO);
        return allAttendances;
    }

    @PostMapping("one")
    public Attendance getAttendanceById(@RequestBody QueryIdDTO queryIdDTO) {
        return attendanceService.getAttendanceById(queryIdDTO.getId()).orElse(null);
    }

    @PostMapping("update")
    public Attendance createAttendance( @RequestBody Attendance attendance) {
        if(attendance.getId() != null){
            return attendanceService.updateAttendance(attendance.getId(),attendance);
        }
        return attendanceService.createAttendance(attendance);
    }

    @PostMapping("del")
    public ResponseEntity<?> deleteAttendance(@RequestBody QueryIdDTO queryIdDTO) {
        attendanceService.deleteAttendance(queryIdDTO.getId());
        return ResponseEntity.ok().build();
    }

    // add other endpoints as needed
}
