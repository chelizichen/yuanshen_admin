package com.czq.back.controller;

import com.czq.back.entity.Research;
import com.czq.back.expection.ResourceNotFoundException;
import com.czq.back.repo.ResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/research")
public class ResearchController {

    @Autowired
    private ResearchRepository researchRepository;

    @GetMapping
    public List<Research> getAllResearch() {
        return researchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Research getResearchById(@PathVariable Long id) {
        return researchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Research not found with id: " + id));
    }

    @PostMapping
    public Research createResearch(@Valid @RequestBody Research research) {
        return researchRepository.save(research);
    }

    @PutMapping("/{id}")
    public Research updateResearch(@PathVariable Long id, @Valid @RequestBody Research researchDetails) {
        Research research = researchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Research not found with id: " + id));
        research.setTopic(researchDetails.getTopic());
        research.setPublishedPapers(researchDetails.getPublishedPapers());
        research.setAwards(researchDetails.getAwards());
        return researchRepository.save(research);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResearch(@PathVariable Long id) {
        Research research = researchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Research not found with id: " + id));
        researchRepository.delete(research);
        return ResponseEntity.ok().build();
    }
}
