package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// This annotation make the default path for all functions inside the class
@RequestMapping(path = "api/v1/student")
/*
 This class is declared as [API layer] which interact with the client,
 which have all resources for API, like POST, GET, DELETE, and so on.
 */
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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

}
