package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.LoginDTO;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Follows;
import com.czq.back.entity.User;
import com.czq.back.repo.FollowsRepository;
import com.czq.back.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FollowsService {

    @Autowired
    private FollowsRepository followsRepository;

    public Follows save(Follows follows) {
        Follows save = followsRepository.save(follows);
        return save;
    }

    public Follows getById(Long id) {
        Optional<Follows> userOptional = followsRepository.findById(id);
        if (userOptional.isPresent()) {
            Follows follows = userOptional.get();
            return follows;
        }
        throw new EntityNotFoundException("user not found with id " + id);
    }

    public Follows update(Follows follows) {
            Follows updatefollwos = followsRepository.save(follows);
            return updatefollwos;
    }

    public void deleteById(Long id) {
        Optional<Follows> userOptional = followsRepository.findById((long)id);
        if (userOptional.isPresent()) {
            followsRepository.delete(userOptional.get());
        } else {
            throw new EntityNotFoundException("user not found with id " + id);
        }
    }

    public ListRet getAll(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Follows> byKeyword = followsRepository.findByKeyword(pageDTO.getKeyword(),pageable);
        List<Follows> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }
}
