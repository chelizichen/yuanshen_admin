package com.czq.back.service;

import com.czq.back.entity.Teacher;
import com.czq.back.repo.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = teacherRepository.findAll();
        return teacherList;
    }

    // add other methods as needed
}
