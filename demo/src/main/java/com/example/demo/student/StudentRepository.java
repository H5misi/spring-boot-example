package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/*
 - This interface is declared as [Data access layer], which work with database
 - This class is extends {JpaRepository<Type, ID>} superclass,
   superclass is containing a pre-defined functions, like: .findAll() , .existById() , .isPresent() ,  and so on
   and if the function is not defined, define it manually here with its implementation
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*
     @Query annotation declare the query between brackets as
     the implementation of the code inside [findStudentByEmail] function but in easy way instead of manually implementation
     */
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
//    Optional type is used because the returned record may have null values or not
    Optional<Student> findStudentByEmail(String email);
}
