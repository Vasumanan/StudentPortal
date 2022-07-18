

/**
 * This AdminController is used to do request mapping to services.
 * 
 * @author Vasumanan J
 *
 */
package com.admin.controller;

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
import com.admin.entity.Admin;
import com.admin.entity.Staff;
import com.admin.services.AdminServices;
import com.admin.services.MapValidationErrorService;



@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminServices adminServices;
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createAdmin(@RequestBody Admin admin , BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		return new ResponseEntity<>(adminServices.createAdmin(admin),HttpStatus.CREATED);
	}
	@GetMapping("/{username}")
	public ResponseEntity<?> findAdminByUsername(@PathVariable String username ){
		return new ResponseEntity<>(adminServices.getAdminByUsername(username),HttpStatus.OK);
	}

	@PostMapping("/{adminId}/staffs")
	public ResponseEntity<?> createStaff(@PathVariable int adminId ,@RequestBody Staff staff){
		return new ResponseEntity<>(adminServices.createStaff(staff,adminId),HttpStatus.CREATED);
	}
	@GetMapping("/{username}/{password}")
	public ResponseEntity<?> login(@PathVariable String username ,@PathVariable String password){
		return new ResponseEntity<>(adminServices.login(username, password),HttpStatus.OK);
	}
	
	@GetMapping("{adminId}/staffs/{staffId}")
	public ResponseEntity<?> findStaffById(@PathVariable int adminId,@PathVariable int staffId){
		Staff staff =adminServices.getStaffById(adminId,staffId);
		if(staff==null)
			return new ResponseEntity<>(staff,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(staff,HttpStatus.OK);
	}
	@GetMapping("/{adminId}/staffs")
	public ResponseEntity<?> findAllStaffs(@PathVariable int adminId){
		return new ResponseEntity<>(adminServices.getAllStaff(adminId),HttpStatus.OK);
	}
	
	@PutMapping("/{adminId}/staffs")
	public ResponseEntity<?> updateStaff(@PathVariable int adminId,@RequestBody Staff staff){
		return new ResponseEntity<>(adminServices.updateStaff(adminId,staff),HttpStatus.OK);		
	}
	
	@DeleteMapping("{adminId}/staffs/{staffId}")
	public ResponseEntity<?> deleteStaff(@PathVariable int adminId,@PathVariable int staffId){
		String response = adminServices.deleteStaff(adminId,staffId);
		if(response.equals("Staff deleted successfully")) {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
}
