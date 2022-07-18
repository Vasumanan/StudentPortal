package com.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.exceptions.StudentNotFoundException;
import com.student.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This StudentServiceImpl will perform all the Student related services
 * 
 * @author Vasumanan J
 *
 */

@Service
@Slf4j
public class StudentServicesImpl implements StudentServices{
	@Autowired
	StudentRepository studentRepository;


	@Override
	public Student createStudent(Student student) {
		student.getMarks().setTotal(student.getMarks().getEnglishMark()+student.getMarks().getTamilMark()+student.getMarks().getMathsMark()+student.getMarks().getScienceMark()+student.getMarks().getSocialMark());
		student.getMarks().setPercentage(student.getMarks().getTotal()/5);
		log.info("Creating Student");
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student){
		if(studentRepository.existsById(student.getStudentId())) {
			student.getMarks().setTotal(student.getMarks().getEnglishMark()+student.getMarks().getTamilMark()+student.getMarks().getMathsMark()+student.getMarks().getScienceMark()+student.getMarks().getSocialMark());
			student.getMarks().setPercentage(student.getMarks().getTotal()/5);
			log.info("updating Student");
			return studentRepository.save(student);
		}
		log.error("Invalid Student Id");
		throw new StudentNotFoundException("Provide valid Student Id");
	}

	@Override
	public String deleteStudent(int studentId) {
		if(studentRepository.existsById(studentId)) {
			studentRepository.deleteById(studentId);
			log.info("Student Deleted");
			return "Student deleted successfully";
		}
		log.error("Invalid StudentId");
		throw new StudentNotFoundException("Provide valid Student Id");
	}

	@Override
	public Student getStudentById(int studentId) {
		if(studentRepository.existsById(studentId))
			return studentRepository.findByStudentId(studentId);
		log.error("Invalid StudentId");
		throw new StudentNotFoundException("Provide valid Student Id");
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public int login(String username, String password) {
		Student student = studentRepository.findByUsernameAndPassword(username, password);
		if(student==null) {
			log.error("Invalid StudentId");			
			throw new StudentNotFoundException("Invalid Username or Password");
		}
		return student.getStudentId();
	}

}
