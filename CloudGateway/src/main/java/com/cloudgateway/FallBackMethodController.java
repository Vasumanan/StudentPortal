package com.cloudgateway;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	@PostMapping("/staffServiceFallBack")
	public String staffServiceFallBackForPostMethod() {
		return "Staff Service is taking longer than expected.Please try again Later";
	}
	
	@GetMapping("/staffServiceFallBack")
	public String staffServiceFallBackForGetMethod() {
		return "Staff Service is taking longer than expected.Please try again Later";
	}
	
	@PutMapping("/staffServiceFallBack")
	public String staffServiceFallBackForPutMethod() {
		return "Staff Service is taking longer than expected.Please try again Later";
	}
	
	@DeleteMapping("/staffServiceFallBack")
	public String staffServiceFallBackForDeleteMethod() {
		return "Staff Service is taking longer than expected.Please try again Later";
	}
	
	@PostMapping("/studentServiceFallBack")
	public String studentServiceFallBackForPostMethod() {
		return "Student Service is taking longer than expected.Please try again Later";
	}
	
	@GetMapping("/studentServiceFallBack")
	public String studentServiceFallBackForGetMethod() {
		return "Student Service is taking longer than expected.Please try again Later";
	}
	
	@PutMapping("/studentServiceFallBack")
	public String studentServiceFallBackForPutMethod() {
		return "Student Service is taking longer than expected.Please try again Later";
	}
	
	@DeleteMapping("/studentServiceFallBack")
	public String studentServiceFallBackForDeleteMethod() {
		return "Student  Service is taking longer than expected.Please try again Later";
	}
}