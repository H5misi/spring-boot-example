package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// this Class is declared as Business logic (Service) class
@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Hazem",
                        "hazem.alkhamisi@gmail.com",
                        LocalDate.of(2001, Month.MAY, 5),
                        23
                )
        );
    }
}
