package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.TitleDTO;
import com.czq.back.entity.Teacher;
import com.czq.back.entity.Title;
import com.czq.back.repo.TeacherRepository;
import com.czq.back.repo.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("title")
public class TitleController {

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping("/list")
    public List<Title> getAllTitle() {
        return titleRepository.findAll();
    }

    @PostMapping("/setTitle")
    public Integer SetTitle(@RequestBody TitleDTO titleDTO){
        Integer teacherId = titleDTO.getTeacherId();
        Integer titleId = titleDTO.getTitleId();
        Teacher referenceById = teacherRepository.getReferenceById(teacherId.longValue());
        referenceById.setTitleId(titleId);
        teacherRepository.save(referenceById);
        return 1;
    }

    @PostMapping("/getByTitle")
    public List<Teacher> getTeacherTitle(@RequestBody TitleDTO titleDTO){
        return teacherRepository.findTeacherByTitle(titleDTO.titleId);
    }
}
