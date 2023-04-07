package com.czq.back.service;

import com.czq.back.entity.Section;
import com.czq.back.repo.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public Section saveSection(Section sectionDTO) {
        Section savedSection = sectionRepository.save(sectionDTO);
        return savedSection;
    }

    public Section getSectionById(Long id) {
        Optional<Section> sectionOptional = sectionRepository.findById(id);
        if (sectionOptional.isPresent()) {
            Section section = sectionOptional.get();
            return section;
        }
        throw new EntityNotFoundException("Section not found with id " + id);
    }

    public Section updateSection(Section sectionDTO) {
        Optional<Section> sectionOptional = sectionRepository.findById(sectionDTO.getId());
        if (sectionOptional.isPresent()) {

            Section updatedSection = sectionRepository.save(sectionDTO);
            return updatedSection;
        }
        throw new EntityNotFoundException("Section not found with id " + sectionDTO.getId());
    }

    public void deleteSectionById(Long id) {
        Optional<Section> sectionOptional = sectionRepository.findById(id);
        if (sectionOptional.isPresent()) {
            sectionRepository.delete(sectionOptional.get());
        } else {
            throw new EntityNotFoundException("Section not found with id " + id);
        }
    }

    public List<Section> getAllSections() {
        List<Section> sectionList = sectionRepository.findAll();
        return sectionList;
    }

    // add other methods as needed
}
