package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 - This Class is declared as Business logic (Service layer) class
   which interact or connect [API layer] with [Data access layer]
 - Inside this class, write all the logic code and operations for [API layer] functions
 */
@Service
public class StudentService {

//    StudentRepository is the interface with the Database,
//    and it has some pre-defined functions, like: .findAll() , .existById() , .isPresent() ,  and so on.
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    Implementation of GET function to get a  student from the database
    public List<Student> getStudents() {

        return studentRepository.findAll();

    }
//    Implementation of POST function, to post check the received email to   new student & save it or throw an exception if it has taken
    public Student addNewStudent(Student body) {
//        Optional type is used because the returned record may have null values or not
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(body.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }

        return studentRepository.save(body);
    }
//    Implementation of DELETE function, to delete an existing student or throw an exception if not exist
    public void deleteStudent(Long studentId) {
         boolean exist = studentRepository.existsById(studentId);

        if (!exist){
            throw new IllegalStateException("Student with ID " + studentId + " does not exist ");
        }

        studentRepository.deleteById(studentId);
    }
}
