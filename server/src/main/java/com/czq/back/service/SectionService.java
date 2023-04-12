package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Course;
import com.czq.back.entity.Section;
import com.czq.back.repo.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public ListRet getAllSections(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Section> byKeyword = sectionRepository.findByKeyword(pageDTO.getKeyword(), pageable);
        List<Section> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    // add other methods as needed
}
