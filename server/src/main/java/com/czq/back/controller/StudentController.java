package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Student;
import com.czq.back.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("update")
    public ResponseEntity<Student> createStudent(@RequestBody Student studentDTO) {
        if(studentDTO.getId() != null){
            Student updatedStudent = studentService.updateStudent(studentDTO);
            return ResponseEntity.ok(updatedStudent);
        }
        Student savedStudent = studentService.saveStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @PostMapping("/get")
    public ResponseEntity<Student> getStudentById(@RequestBody QueryIdDTO queryIdDTO) {
        Student studentDTO = studentService.getStudentById(queryIdDTO.getId());
        return ResponseEntity.ok(studentDTO);
    }


    @PostMapping("/del")
    public ResponseEntity<?> deleteStudent(@RequestBody QueryIdDTO queryIdDTO) {
        studentService.deleteStudentById(queryIdDTO.getId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("list")
    public ListRet getAllStudents(@RequestBody PageDTO pageDTO) {
        final ListRet allStudents = studentService.getAllStudents(pageDTO);
        return allStudents;
    }

    // add other endpoints as needed
}
