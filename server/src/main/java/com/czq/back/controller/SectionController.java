package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.Section;
import com.czq.back.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping("/one")
    public ResponseEntity<Section> getSectionById(@RequestBody QueryIdDTO queryIdDTO) {
        Section sectionDTO = sectionService.getSectionById(queryIdDTO.getId());
        return ResponseEntity.ok(sectionDTO);
    }

    @PostMapping("update")
    public ResponseEntity<Section> updateSection(@RequestBody Section sectionDTO) {
        if(sectionDTO.getId() != null){
            Section updatedSection = sectionService.updateSection(sectionDTO);
            return ResponseEntity.ok(updatedSection);
        }
        Section savedSection = sectionService.saveSection(sectionDTO);
        return ResponseEntity.status(HttpStatus.CREATED). body(savedSection);
    }

    @PostMapping("/del")
    public ResponseEntity<?> deleteSection(@PathVariable Long id) {
        sectionService.deleteSectionById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("list")
    public ListRet getAllSections(@RequestBody PageDTO pageDTO) {
        final ListRet allSections = sectionService.getAllSections(pageDTO);
        return allSections;
    }

    // add other endpoints as needed
}
