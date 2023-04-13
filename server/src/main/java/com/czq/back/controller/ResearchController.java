package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Assignment;
import com.czq.back.entity.Research;
import com.czq.back.expection.ResourceNotFoundException;
import com.czq.back.repo.ResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/research")
public class ResearchController {

    @Autowired
    private ResearchRepository researchRepository;

    @PostMapping("list")
    public ListRet getAllResearch(@RequestBody PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Research> byKeyword = researchRepository.findByKeyword(pageDTO.getKeyword(), pageable);
        List<Research> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    @PostMapping("one")
    public Research getResearchById(@RequestBody QueryIdDTO queryIdDTO) {
        return researchRepository.findById(queryIdDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Research not found with id: " + queryIdDTO.getId()));
    }

    @PostMapping("update")
    public Research createResearch(@Valid @RequestBody Research researchDetail) {
        if(researchDetail.getResearchId() != null){
            return researchRepository.save(researchDetail);
        }
        return researchRepository.save(researchDetail);
    }

    @PostMapping("del")
    public ResponseEntity<?> deleteResearch(@RequestBody QueryIdDTO queryIdDTO) {
        Research research = researchRepository.findById(queryIdDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Research not found with id: " + queryIdDTO.getId()));
        researchRepository.delete(research);
        return ResponseEntity.ok().build();
    }
}
