package com.czq.back.controller;

import com.czq.back.entity.Attendance;
import com.czq.back.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public ResponseEntity<?> markAttendance(@RequestBody Attendance attendanceDTO) {
        attendanceService.markAttendance(attendanceDTO);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<List<Attendance>> getAttendanceByTeacherId(@PathVariable Long id) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByTeacherId(id);
        return ResponseEntity.ok(attendanceList);
    }

    // add other endpoints as needed
}
