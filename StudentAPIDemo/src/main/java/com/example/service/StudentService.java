package com.example.service;

import java.util.List;

import com.example.dto.StudentDTO;
import com.example.exception.StudentException;
//Service Class Methods 
public interface StudentService {
	public StudentDTO getStudent(Integer id) throws StudentException;
	public List<StudentDTO> getAllStudent() throws StudentException;
	public Integer addStudent(StudentDTO studentDTO) throws StudentException;
	public void updateStudent(Integer id,String email) throws StudentException;
	public void deleteStudent(Integer id) throws StudentException;
}
