package com.example.studentsubject;

import com.example.studentsubject.entity.Student;
import com.example.studentsubject.entity.Subject;
import com.example.studentsubject.repository.StudentRepository;
import com.example.studentsubject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentSubjectApplication implements Runnable {

    public static void main(String[] args) {
        SpringApplication.run(StudentSubjectApplication.class, args);
    }




    @Override
    public void run() {

    }
}
