package com.czq.back.service;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.PageDTO;
import com.czq.back.entity.Course;
import com.czq.back.entity.Student;
import com.czq.back.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student studentDTO) {
        Student savedStudent = studentRepository.save(studentDTO);
        return savedStudent;
    }

    public Student getStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return student;
        }
        throw new EntityNotFoundException("Student not found with id " + id);
    }

    public Student updateStudent(Student studentDTO) {
        Optional<Student> studentOptional = studentRepository.findById(studentDTO.getId());
        if (studentOptional.isPresent()) {
            Student updatedStudent = studentRepository.save(studentDTO);
            return updatedStudent;
        }
        throw new EntityNotFoundException("Student not found with id " + studentDTO.getId());
    }

    public void deleteStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
        } else {
            throw new EntityNotFoundException("Student not found with id " + id);
        }
    }

    public ListRet getAllStudents(PageDTO pageDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getSize());
        Page<Student> byKeyword = studentRepository.findByKeyword(pageDTO.getKeyword(), pageable);
        List<Student> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }

    // add other methods as needed
}
