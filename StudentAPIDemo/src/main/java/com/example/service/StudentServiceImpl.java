package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.StudentDTO;
import com.example.entity.Student;
import com.example.exception.StudentException;
import com.example.repository.StudentRepository;

@Service(value = "studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public StudentDTO getStudent(Integer id) throws StudentException {
		Optional<Student> optional=studentRepository.findById(id);
		Student student=optional.orElseThrow(() -> new StudentException("Service.STUDENT_NOT_FOUND"));
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setCountry(student.getCountry());
		studentDTO.setDob(student.getDob());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setId(student.getId());
		studentDTO.setName(student.getName());
		return studentDTO;
	}

	@Override
	public List<StudentDTO> getAllStudent() throws StudentException {
		Iterable<Student> optional=studentRepository.findAll();
		List<StudentDTO> studentDTOs=new ArrayList<>();
		optional.forEach(student ->{
			StudentDTO studentDTO=new StudentDTO();
			studentDTO.setCountry(student.getCountry());
			studentDTO.setDob(student.getDob());
			studentDTO.setEmail(student.getEmail());
			studentDTO.setId(student.getId());
			studentDTO.setName(student.getName());
			studentDTOs.add(studentDTO);
		}
		);
		if (studentDTOs.isEmpty()) {
			throw new StudentException("Service.STUDENTS_NOT_FOUND");
		}
		return studentDTOs;
	}

	@Override
	public Integer addStudent(StudentDTO studentDTO) throws StudentException {
		Student student=new Student();
		student.setCountry(studentDTO.getCountry());
		student.setDob(studentDTO.getDob());
		student.setEmail(studentDTO.getEmail());
		student.setId(studentDTO.getId());
		student.setName(studentDTO.getName());
		Student student2=studentRepository.save(student);
		return student2.getId();
	}

	@Override
	public void updateStudent(Integer id, String email) throws StudentException {
		Optional<Student> optional=studentRepository.findById(id);
		Student student=optional.orElseThrow(() -> new StudentException("Service.STUDENT_NOT_FOUND"));
		student.setEmail(email);
		
	}

	@Override
	public void deleteStudent(Integer id) throws StudentException {
		Optional<Student> optional=studentRepository.findById(id);
		Student student=optional.orElseThrow(() -> new StudentException("Service.STUDENT_NOT_FOUND"));
		studentRepository.deleteById(student.getId());
		
	}

}
