package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Schedule;
import com.czq.back.entity.Section;
import com.czq.back.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ListRet getAllSchedules(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Schedule> byKeyword = scheduleRepository.findByKeyword(pageDTO.getKeyword(), pageable);
        List<Schedule> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public ListRet findById(QueryIdDTO queryIdDTO) {
        final List<Schedule> byTeacherId = scheduleRepository.getByTeacherId(queryIdDTO.getId());
        final ListRet listRet = new ListRet(byTeacherId, (long) byTeacherId.size());
        return listRet;
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Long id, Schedule schedule) {
        Optional<Schedule> existingSchedule = scheduleRepository.findById(id);
        if (existingSchedule.isPresent()) {
            schedule.setId(id);
            return scheduleRepository.save(schedule);
        }
        return null;
    }

    public boolean deleteSchedule(Long id) {
        Optional<Schedule> existingSchedule = scheduleRepository.findById(id);
        if (existingSchedule.isPresent()) {
            scheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
