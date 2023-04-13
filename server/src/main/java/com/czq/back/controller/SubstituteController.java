package com.czq.back.controller;

import com.czq.back.entity.Substitute;
import com.czq.back.service.SubstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/substitutes")
public class SubstituteController {
    @Autowired
    private SubstituteService substituteService;


    @GetMapping
    public List<Substitute> getAllSubstitutes() {
        return substituteService.getAllSubstitutes();
    }

    @GetMapping("/{id}")
    public Substitute getSubstituteById(@PathVariable Long id) {
        return substituteService.getSubstituteById(id);
    }

    @PostMapping
    public Substitute createSubstitute(@RequestBody Substitute substitute) {
        return substituteService.createSubstitute(substitute);
    }

    @PutMapping("/{id}")
    public Substitute updateSubstitute(@PathVariable Long id, @RequestBody Substitute substitute) {
        return substituteService.updateSubstitute(id, substitute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSubstitute(@PathVariable Long id) {
        boolean isDeleted = substituteService.deleteSubstitute(id);
        return ResponseEntity.ok(isDeleted);
    }
}
