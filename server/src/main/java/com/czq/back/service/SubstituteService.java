package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Student;
import com.czq.back.entity.Substitute;
import com.czq.back.repo.SubstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubstituteService {
    @Autowired
    private  SubstituteRepository substituteRepository;


    public ListRet getAllSubstitutes(PageDTO pageDTO) {

        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Substitute> byKeyword = substituteRepository.findByKeyword(pageDTO.getKeyword(), pageable);
        List<Substitute> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public Substitute getSubstituteById(Long id) {
        return substituteRepository.findById(id).orElse(null);
    }

    public Substitute createSubstitute(Substitute substitute) {
        return substituteRepository.save(substitute);
    }

    public Substitute updateSubstitute(Long id, Substitute substituteDetails) {
        Substitute substitute = substituteRepository.findById(id).orElse(null);
        if (substitute == null) {
            return null;
        }
        return substituteRepository.save(substitute);
    }

    public boolean deleteSubstitute(Long id) {
        Substitute substitute = substituteRepository.findById(id).orElse(null);
        if (substitute == null) {
            return false;
        }
        substituteRepository.delete(substitute);
        return true;
    }
}
