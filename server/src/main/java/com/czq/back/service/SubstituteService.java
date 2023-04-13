package com.czq.back.service;

import com.czq.back.entity.Substitute;
import com.czq.back.repo.SubstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubstituteService {
    @Autowired
    private  SubstituteRepository substituteRepository;


    public List<Substitute> getAllSubstitutes() {
        return substituteRepository.findAll();
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
