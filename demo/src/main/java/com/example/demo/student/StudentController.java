package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// This annotation make the default path for all functions inside the class
@RequestMapping(path = "api/student")
/*
 This class is declared as [API layer] which interact with the client,
 which have all resources for API, like POST, GET, DELETE, and so on.
 */
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

//    GET request
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

//    POST request
    @PostMapping
    public Student registerNewStudent(@RequestBody Student body){ // @RequestBody is to detect that the variable data is from JSON body
//        return here is used to return the record that has been added to the Database
        return studentService.addNewStudent(body);
    }

//    DELETE request
    @DeleteMapping(path = "{studentId}") // Path="{...}" is for add a PathVariable to the default path (which is from @RequestMapping)
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

//    PUT request
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              /*
                              * - @RequestParam is used to extract individual parameter values from the request URL or submitted form data
                              * - Method parameters annotated with @RequestParam are required by default,
                              *   by using required = false it makes the method optional
                               */
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}
