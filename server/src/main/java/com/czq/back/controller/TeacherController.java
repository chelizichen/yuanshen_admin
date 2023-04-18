package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.LoginDTO;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Teacher;
import com.czq.back.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @PostMapping("/list")
    public ListRet getAllTeachers(@RequestBody PageDTO pageDTO) {
        pageDTO.setPage(pageDTO.getPage()-1);
        return teacherService.getAllTeachers(pageDTO);
    }

    @PostMapping("/admin/list")
    public ListRet AdminGetAllTeachers(@RequestBody PageDTO pageDTO) {
        pageDTO.setPage(pageDTO.getPage()-1);
        return teacherService.AdminFindByKeyword(pageDTO);
    }

    @PostMapping("/one")
    public Teacher getTeacherById(@RequestBody QueryIdDTO queryIdDTO) {
        return teacherService.getTeacherById(queryIdDTO.getId());
    }

    @PostMapping("/update")
    public Teacher updateTeacher(@RequestBody Teacher teacherDetails) {
        System.out.println("测试打印"+teacherDetails);
        if(teacherDetails.getId() != null){
            final Teacher teacher = teacherService.updateTeacher(teacherDetails);
            return teacher;
        }else{
            final Teacher teacher = teacherService.saveTeacher(teacherDetails);
            return teacher;
        }
    }

    @PostMapping("/del")
    public ResponseEntity<?> deleteTeacher(@RequestBody QueryIdDTO queryIdDTO) {
        teacherService.deleteTeacherById(queryIdDTO.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public Teacher login(@RequestBody LoginDTO loginDTO) {
        return teacherService.login(loginDTO);
    }

}
