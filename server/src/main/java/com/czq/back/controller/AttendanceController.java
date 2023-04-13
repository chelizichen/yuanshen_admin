package com.czq.back.controller;

import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Attendance;
import com.czq.back.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // add other endpoints as needed
}
