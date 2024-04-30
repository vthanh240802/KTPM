package com.example.studentsubject.repository;

import com.example.studentsubject.entity.Registration;
import com.example.studentsubject.entity.Student;
import com.example.studentsubject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findAllByStudent(Student student);

}
