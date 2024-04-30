package com.example.studentsubject.service.impl;

import com.example.studentsubject.entity.Subject;
import com.example.studentsubject.repository.SubjectRepository;
import com.example.studentsubject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }
}
