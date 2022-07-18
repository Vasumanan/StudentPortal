/**
 * This StaffController is used to do request mapping to services.
 * 
 * @author Vasumanan J
 *
 */

package com.staff.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.staff.entity.Staff;
import com.staff.entity.Student;
import com.staff.services.MapValidationErrorService;
import com.staff.services.StaffServices;

@RestController
@RequestMapping("/staffs")
@CrossOrigin
public class StaffController {

	@Autowired
	StaffServices staffServices;
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	@GetMapping("/{username}/{password}")
	public ResponseEntity<?> login(@PathVariable String username,@PathVariable String password){
		int staffId = staffServices.login(username, password);
		if(staffId>0)
			return new ResponseEntity<>(staffId,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("{staffId}/students")
	public ResponseEntity<?> createStudent(@PathVariable int staffId,@RequestBody Student student){
		return new ResponseEntity<>(staffServices.createStudent(staffId,student),HttpStatus.OK);
	}
	
	@GetMapping("{staffId}/students/{studentId}")
	public ResponseEntity<?> findStudentById(@PathVariable int staffId,@PathVariable int studentId){
		return new ResponseEntity<>(staffServices.getStudentById(staffId,studentId),HttpStatus.OK);
	}
	@GetMapping("{staffId}/students")
	public ResponseEntity<?> findAllStudents(@PathVariable int staffId){
		return new ResponseEntity<>(staffServices.getAllStudents(staffId),HttpStatus.OK);
	}
	
	@PutMapping("{staffId}/students")
	public ResponseEntity<?> updateStudent(@PathVariable int staffId,@RequestBody Student student){
		return new ResponseEntity<>(staffServices.updateStudent(staffId,student),HttpStatus.OK);		
	}
	
	@DeleteMapping("{staffId}/students/{studentId}")
	public ResponseEntity<?>  deleteStudent(@PathVariable int staffId,@PathVariable int studentId){
		return new ResponseEntity<>(staffServices.deleteStudent(staffId,studentId),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createStaff(@RequestBody Staff staff , BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		return new ResponseEntity<>(staffServices.createStaff(staff),HttpStatus.OK);
	}
	
	@GetMapping("/{staffId}")
	public ResponseEntity<?> findStaffById(@PathVariable int staffId){
		return new ResponseEntity<>(staffServices.getStaffById(staffId),HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<?> updateStaff(@RequestBody Staff staff){
		return new ResponseEntity<>(staffServices.updateStaff(staff),HttpStatus.OK);		
	}
	
	@DeleteMapping("/{staffId}")
	public ResponseEntity<?> deleteStaff(@PathVariable int staffId){
		return new ResponseEntity<>(staffServices.deleteStaff(staffId),HttpStatus.OK);
	}
	@GetMapping("")
	public ResponseEntity<?> findAllStaffs(){
		return new ResponseEntity<>(staffServices.getAllStaff(),HttpStatus.OK);
	}
	@GetMapping("staff/{username}")
	public ResponseEntity<?> findStaffByUsername(@PathVariable(value="username") String username){
		return new ResponseEntity<>(staffServices.getStaffByUsername(username),HttpStatus.OK);
	}
}
