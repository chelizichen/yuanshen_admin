package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.LoginDTO;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.User;
import com.czq.back.repo.UserRepository;
import io.lettuce.core.ScriptOutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    public User getuserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user;
        }
        throw new EntityNotFoundException("user not found with id " + id);
    }

    public User updateuser(User userDTO) {
        Optional<User> userOptional = userRepository.findById(userDTO.getUserId());
        if (userOptional.isPresent()) {
            User updateduser = userRepository.save(userDTO);
            return updateduser;
        }
        throw new EntityNotFoundException("user not found with id " + userDTO.getUserId());
    }

    public void deleteuserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new EntityNotFoundException("user not found with id " + id);
        }
    }

    public ListRet getAllusers(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<User> byKeyword = userRepository.findByKeyword(pageDTO.getKeyword(),pageable);
        List<User> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }


    public User login (LoginDTO loginDTO){
        final Optional<User> byUsername = userRepository.findByUsername(loginDTO.getUsername());
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            if (user.getPassword().equals(loginDTO.getPassword())) {
                return user;
            }
        }
        return null;
    }

    // add other methods as needed
}
