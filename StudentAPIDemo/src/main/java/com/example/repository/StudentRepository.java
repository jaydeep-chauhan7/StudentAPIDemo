package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Student;
//Repository Class 
public interface StudentRepository extends CrudRepository<Student,Integer> {

}
