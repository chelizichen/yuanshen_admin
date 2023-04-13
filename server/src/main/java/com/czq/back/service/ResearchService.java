package com.czq.back.service;

import com.czq.back.entity.Research;
import com.czq.back.repo.ResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchService {
    @Autowired
    private ResearchRepository researchRepository;

    public List<Research> getAllResearch() {
        return researchRepository.findAll();
    }

    public Optional<Research> getResearchById(Long id) {
        return researchRepository.findById(id);
    }

    public Research createResearch(Research research) {
        return researchRepository.save(research);
    }

    public Research updateResearch(Long id, Research research) {
        Optional<Research> existingResearch = researchRepository.findById(id);
        if (existingResearch.isPresent()) {
            research.setResearchId(id);
            return researchRepository.save(research);
        }
        return null;
    }

    public boolean deleteResearch(Long id) {
        Optional<Research> existingResearch = researchRepository.findById(id);
        if (existingResearch.isPresent()) {
            researchRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
