package com.czq.back.service;

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
            research.setId(id);
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
