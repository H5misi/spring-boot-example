package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

// Map "student" class to database
@Entity
@Table
// This class is declared as the Table in the database
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

//    Constructor without attributes
    public Student() {
    }

//    Constructor with all attributes
    public Student(Long id, String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.id = id;
    }

//    Constructor with all attributes except ID (will be auto generated using database)
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
