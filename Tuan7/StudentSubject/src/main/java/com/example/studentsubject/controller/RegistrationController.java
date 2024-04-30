package com.example.studentsubject.controller;

import com.example.studentsubject.entity.Registration;
import com.example.studentsubject.entity.Subject;
import com.example.studentsubject.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    ResponseEntity<List<Registration>> getAll(){
        return ResponseEntity.ok(registrationService.getAll());
    }

    @GetMapping("/find")
    ResponseEntity<List<Subject>> getRegisteredSubjectByStudentId(@RequestParam(name = "student_id") Long studentId ){
        return ResponseEntity.ok(registrationService.getRegisteredSubjectByStudentId(studentId));
    }

    @PostMapping("/registrate")
    ResponseEntity<Registration> registrate(@RequestParam(name = "student_id") Long studentId, @RequestParam(name = "subject_id") Long subjectId ) throws BadRequestException {
        return ResponseEntity.ok(registrationService.register(subjectId, studentId));
    }
}
