package com.example.studentsubject.controller;

import com.example.studentsubject.entity.Subject;
import com.example.studentsubject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    ResponseEntity<List<Subject>> getAll(){
        return ResponseEntity.ok(subjectService.getAll());
    }

}
