package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Substitute;
import com.czq.back.service.SubstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("substitutes")
public class SubstituteController {
    @Autowired
    private SubstituteService substituteService;


    @PostMapping("list")
    public ListRet getAllSubstitutes(@RequestBody PageDTO pageDTO) {
        pageDTO.setPage(pageDTO.getPage() - 1);
        return substituteService.getAllSubstitutes(pageDTO);
    }

    @PostMapping("one")
    public Substitute getSubstituteById(@RequestBody QueryIdDTO queryIdDTO) {
        return substituteService.getSubstituteById(queryIdDTO.getId());
    }


    @PostMapping("update")
    public Substitute updateSubstitute(@RequestBody Substitute substitute) {
        if(substitute.getId() != null){
            return substituteService.updateSubstitute(substitute.getId(),substitute);
        }
        return  substituteService.createSubstitute(substitute);
    }

    @PostMapping("del")
    public ResponseEntity<Boolean> deleteSubstitute(@RequestBody QueryIdDTO queryIdDTO) {
        boolean isDeleted = substituteService.deleteSubstitute(queryIdDTO.getId());
        return ResponseEntity.ok(isDeleted);
    }
}
