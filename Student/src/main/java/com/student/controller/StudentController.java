
/**
 * This StudentController is used to do request mapping to services.
 * 
 * @author Vasumanan J
 *
 */

package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.entity.Student;
import com.student.services.MapValidationErrorService;
import com.student.services.StudentServices;


@RestController
@CrossOrigin
public class StudentController {
	@Autowired
	StudentServices studentServices;
	@Autowired
	MapValidationErrorService mapValidationErrorService;

	@GetMapping("students/{username}/{password}")
	public ResponseEntity<?> login(@PathVariable String username,@PathVariable String password){
		int studentId = studentServices.login(username, password);
		if(studentId>0)
			return new ResponseEntity<>(studentId,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/students")
	public ResponseEntity<?> createStudent(@RequestBody Student student , BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		return new ResponseEntity<>(studentServices.createStudent(student),HttpStatus.OK);
	}
	
	@GetMapping("/students/{studentId}")
	public ResponseEntity<?> findStudentById(@PathVariable int studentId){
		return new ResponseEntity<>(studentServices.getStudentById(studentId),HttpStatus.OK);
	}

	@GetMapping("/students")
	public ResponseEntity<?> findAllStudent(){
		return new ResponseEntity<>(studentServices.getAllStudents(),HttpStatus.OK);
	}
	
	@PutMapping("/students")
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		return new ResponseEntity<>(studentServices.updateStudent(student),HttpStatus.OK);		
	}
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable int studentId){
		return new ResponseEntity<>(studentServices.deleteStudent(studentId),HttpStatus.OK);
	}
}
