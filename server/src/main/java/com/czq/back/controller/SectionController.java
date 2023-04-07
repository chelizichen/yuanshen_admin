package com.czq.back.controller;

import com.czq.back.entity.Section;
import com.czq.back.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping
    public ResponseEntity<Section> createSection(@RequestBody Section sectionDTO) {
        Section savedSection = sectionService.saveSection(sectionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSection);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable Long id) {
        Section sectionDTO = sectionService.getSectionById(id);
        return ResponseEntity.ok(sectionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Section> updateSection(@PathVariable Long id, @RequestBody Section sectionDTO) {
        sectionDTO.setId(id);
        Section updatedSection = sectionService.updateSection(sectionDTO);
        return ResponseEntity.ok(updatedSection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSection(@PathVariable Long id) {
        sectionService.deleteSectionById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Section>> getAllSections() {
        List<Section> sectionDTOList = sectionService.getAllSections();
        return ResponseEntity.ok(sectionDTOList);
    }

    // add other endpoints as needed
}
