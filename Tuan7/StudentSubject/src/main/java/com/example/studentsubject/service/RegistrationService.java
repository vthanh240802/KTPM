package com.example.studentsubject.service;

import com.example.studentsubject.entity.Registration;
import com.example.studentsubject.entity.Subject;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface RegistrationService {

    List<Registration> getAll();

    List<Subject> getRegisteredSubjectByStudentId(Long studentId);

    Registration register(Long subjectId, Long studentId) throws BadRequestException;


}
