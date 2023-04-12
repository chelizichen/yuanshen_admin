package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Assignment;
import com.czq.back.expection.ResourceNotFoundException;
import com.czq.back.repo.AssignmentRepository;
import com.czq.back.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("list")
    public ListRet getAllAssignments(@RequestBody PageDTO pageDTO) {
        return assignmentService.getAllAssignments(pageDTO);
    }

    @PostMapping("/one")
    public Assignment getAssignmentById(@RequestBody QueryIdDTO queryIdDTO) {
        return assignmentService.getAssignmentById(queryIdDTO.getId());
    }

    @PostMapping("update")
    public Assignment updateAssignment(  @RequestBody Assignment assignmentDetails) {
        if(assignmentDetails.getId() != null){
            return assignmentService.updateAssignment(assignmentDetails.getId(), assignmentDetails);
        }else {
            return assignmentService.createAssignment(assignmentDetails);
        }
    }

    @PostMapping("del")
    public ResponseEntity<?> deleteAssignment(@RequestBody QueryIdDTO queryIdDTO) {
        assignmentService.deleteAssignment(queryIdDTO.getId());
        return ResponseEntity.ok().build();
    }
}
