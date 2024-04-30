package com.example.studentsubject.controller;

import com.example.studentsubject.entity.Student;
import com.example.studentsubject.entity.Subject;
import com.example.studentsubject.repository.StudentRepository;
import com.example.studentsubject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @GetMapping
    void initData(){
        Student student1 = Student.builder().email("nguyenvana@gmail.com").name("Nguyen Van A").build();
        Student student2 = Student.builder().email("nguyenvanb@gmail.com").name("Nguyen Van B").build();
        Student student3 = Student.builder().email("nguyenvanb@gmail.com").name("Nguyen Van C").build();
        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        System.out.println("3 student has been saved");

        Subject subject1 = Subject.builder().name("Kien truc phan mem").build();
        Subject subject2 = Subject.builder().name("Lap trinh phan tan").build();
        Subject subject3 = Subject.builder().name("Lap trinh WWW").build();
        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
        subjectRepository.save(subject3);
        System.out.println("3 subject has been saved");
    }

}
