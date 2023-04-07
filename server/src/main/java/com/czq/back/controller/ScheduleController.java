package com.czq.back.controller;

import com.czq.back.entity.Schedule;
import com.czq.back.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule scheduleDTO) {
        Schedule savedSchedule = scheduleService.createSchedule(scheduleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSchedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Schedule>> getScheduleById(@PathVariable Long id) {
        Optional<Schedule> scheduleDTO = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(scheduleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule scheduleDTO) {
        Schedule updatedSchedule = scheduleService.updateSchedule(id,scheduleDTO);
        return ResponseEntity.ok(updatedSchedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> scheduleDTOList = scheduleService.getAllSchedules();
        return ResponseEntity.ok(scheduleDTOList);
    }

    // add other endpoints as needed
}
