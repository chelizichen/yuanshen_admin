package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.LoginDTO;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Teacher;
import com.czq.back.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @PostMapping("/list")
    public ListRet getAllTeachers(@RequestBody PageDTO pageDTO) {
        return teacherService.getAllTeachers(pageDTO);
    }

    @PostMapping("/one")
    public Teacher getTeacherById(@RequestParam("id") Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/update")
    public Teacher updateTeacher(@RequestBody Teacher teacherDetails) {

        if(teacherDetails.getId() != null){
            final Teacher teacher = teacherService.saveTeacher(teacherDetails);
            return teacher;
        }else{
            final Teacher teacher = teacherService.updateTeacher(teacherDetails);
            return teacher;
        }
    }

    @GetMapping("/del")
    public ResponseEntity<?> deleteTeacher(@RequestParam("id") Long id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public Teacher login(@Valid @RequestBody LoginDTO loginDTO) {
        return teacherService.login(loginDTO);
    }

}
