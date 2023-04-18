package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.LoginDTO;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Teacher;
import com.czq.back.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setCertification(teacherDTO.getCertification());
        teacher.setPhone(teacherDTO.getPhone());
        teacher.setExperience(teacherDTO.getExperience());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setStatus(teacherDTO.getStatus());
        // set other teacher properties as needed
        Teacher savedTeacher = teacherRepository.save(teacher);
        return savedTeacher;
    }

    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();
            return teacher;
        }
        throw new EntityNotFoundException("Teacher not found with id " + id);
    }

    public Teacher updateTeacher(Teacher teacherDTO) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherDTO.getId());
        if (teacherOptional.isPresent()) {
            Teacher updatedTeacher = teacherRepository.save(teacherDTO);
            return updatedTeacher;
        }
        throw new EntityNotFoundException("Teacher not found with id " + teacherDTO.getId());
    }

    public void deleteTeacherById(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            teacherRepository.delete(teacherOptional.get());
        } else {
            throw new EntityNotFoundException("Teacher not found with id " + id);
        }
    }

    public ListRet getAllTeachers(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Teacher> byKeyword = teacherRepository.findByKeyword(pageDTO.getKeyword(),pageable);
        List<Teacher> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public ListRet AdminFindByKeyword(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Teacher> byKeyword = teacherRepository.AdminFindByKeyword(pageDTO.getKeyword(),pageable);
        List<Teacher> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    public Teacher login (LoginDTO loginDTO){
        final Optional<Teacher> byPhone = teacherRepository.findByPhone(loginDTO.getPhone());
        if(byPhone.isPresent()){
            if (byPhone.get().getPassword().equals(loginDTO.getPassword())) {
                return byPhone.get();
            }
            return null;
        }
        return null;
    }

    // add other methods as needed
}
