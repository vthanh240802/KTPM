package com.example.studentsubject.controller;

import com.example.studentsubject.entity.Student;
import com.example.studentsubject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping
    ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }
}
