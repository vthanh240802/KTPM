package com.example.studentsubject.service.impl;

import com.example.studentsubject.entity.Registration;
import com.example.studentsubject.entity.Student;
import com.example.studentsubject.entity.Subject;
import com.example.studentsubject.repository.RegistrationRepository;
import com.example.studentsubject.repository.StudentRepository;
import com.example.studentsubject.repository.SubjectRepository;
import com.example.studentsubject.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final RegistrationRepository registrationRepository;


    @Override
    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }

    @Override
    public List<Subject> getRegisteredSubjectByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null)
            return null;
        List<Registration> list = registrationRepository.findAllByStudent(student);
        List<Subject> subjects = new ArrayList<>();
        list.forEach((item) -> {
            subjects.add(item.getSubject());
        });
        return subjects;
    }

    @Override
    public Registration register(Long subjectId, Long studentId) throws BadRequestException {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null)
            throw new BadRequestException("student not found");

        Subject subject = subjectRepository.findById(subjectId).orElse(null);
        if (subject == null)
            throw new BadRequestException("subject not found");

        Registration registration = Registration.builder()
                .student(student)
                .subject(subject)
                .registerDate(LocalDate.now())
                .build();

        return registrationRepository.save(registration);
    }
}
