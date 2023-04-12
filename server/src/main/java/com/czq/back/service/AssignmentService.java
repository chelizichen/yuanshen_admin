package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Assignment;
import com.czq.back.repo.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public ListRet getAllAssignments(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Assignment> byKeyword = assignmentRepository.findByKeyword(pageDTO.getKeyword(), pageable);
        List<Assignment> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public Assignment getAssignmentById(Long id) {
        final Assignment assignment = assignmentRepository.findById(id).orElse(null);
        return assignment;
    }

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment updateAssignment(Long id, Assignment assignment) {
        Optional<Assignment> existingAssignment = assignmentRepository.findById(id);
        if (existingAssignment.isPresent()) {
            assignment.setId(id);
            return assignmentRepository.save(assignment);
        }
        return null;
    }

    public boolean deleteAssignment(Long id) {
        Optional<Assignment> existingAssignment = assignmentRepository.findById(id);
        if (existingAssignment.isPresent()) {
            assignmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
