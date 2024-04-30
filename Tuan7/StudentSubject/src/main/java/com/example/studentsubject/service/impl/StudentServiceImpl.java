package com.example.studentsubject.service.impl;

import com.example.studentsubject.entity.Student;
import com.example.studentsubject.repository.StudentRepository;
import com.example.studentsubject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
