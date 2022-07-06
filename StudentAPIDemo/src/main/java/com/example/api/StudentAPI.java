package com.example.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.StudentDTO;
import com.example.exception.StudentException;
import com.example.service.StudentService;

@RestController
@RequestMapping(value = "/")
public class StudentAPI {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "students/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) throws StudentException{
		StudentDTO studentDTO=studentService.getStudent(id);
		//System.out.println(studentDTO.getName());
		return new ResponseEntity<>(studentDTO,HttpStatus.OK);
	}
	
	@GetMapping(value = "students")
	public ResponseEntity<List<StudentDTO>> getAllStudents() throws StudentException{
		List<StudentDTO> list=studentService.getAllStudent();
		//System.out.println(list);
		return new ResponseEntity<List<StudentDTO>>(list,HttpStatus.OK);
	}
	
	@PostMapping(value = "students")
	public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) throws StudentException{
		Integer id=studentService.addStudent(studentDTO);
		String successMessage=environment.getProperty("API.INSERT_SUCCESS")+id;
		//System.err.println(successMessage);
		return new ResponseEntity<String>(successMessage,HttpStatus.CREATED);
	}
	@PutMapping(value = "students/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Integer id,@RequestBody StudentDTO studentDTO) throws StudentException{
		studentService.updateStudent(id, studentDTO.getEmail());
		String successMessage=environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<String>(successMessage,HttpStatus.OK);
	}
	@DeleteMapping(value = "students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) throws StudentException{
		studentService.deleteStudent(id);
		String successMessage=environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage,HttpStatus.OK);
	}
	
}
