package com.staff.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.staff.entity.Staff;
import com.staff.entity.Student;
import com.staff.exceptions.StaffNotFoundException;
import com.staff.repository.StaffRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This StaffServiceImpl will perform all the Staff related services
 * 
 * @author Vasumanan J
 *
 */
@Service
@Slf4j
public class StaffServicesImpl implements StaffServices{

	@Autowired
	StaffRepository staffRepository;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public int login(String username, String password) {
		Staff staff = staffRepository.findByUsernameAndPassword(username, password);
		if(staff==null) {
			log.error("Invalid username or password");
			throw new StaffNotFoundException("Invalid username or password");
		}
		log.info("Login success");
		return staff.getStaffId();
	}

	@Override
	public Student createStudent(int staffId,Student student) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+staffRepository.findByStaffId(staffId).getAuthToken());
		HttpEntity<Student> entity = new HttpEntity<Student>(student,headers);
		log.info("Student Created");
		return restTemplate.postForObject("http://STUDENT-SERVICE/students", entity,Student.class);	
	}

	@Override
	public String updateStudent(int staffId,Student student) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+staffRepository.findByStaffId(staffId).getAuthToken());
		HttpEntity<Student> entity = new HttpEntity<Student>(student,headers);
		try {
			restTemplate.exchange("http://STUDENT-SERVICE/students",HttpMethod.PUT,entity,Student.class);
		}
		catch(RuntimeException e) {
			log.error("Invalid StaffId");
			return e.getMessage();
		}
		log.info("Student updated");
		return "Student Updated";
	}

	@Override
	public String deleteStudent(int staffId,int studentId) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+staffRepository.findByStaffId(staffId).getAuthToken());
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		try {
			 ResponseEntity<String> responseEntity = restTemplate.exchange("http://STUDENT-SERVICE/students/"+studentId,HttpMethod.DELETE, requestEntity,String.class);
			 log.info("Student deleted");
			 return responseEntity.getBody();
		}
		catch(RuntimeException e) {
			log.error("Invalid Staff Id");
			return e.getMessage();
		}
	}

	@Override
	public Student getStudentById(int staffId,int studentId) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+staffRepository.findByStaffId(staffId).getAuthToken());
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		try {
			ResponseEntity<Student> responseEntity = restTemplate.exchange("http://STUDENT-SERVICE/students/"+studentId,HttpMethod.GET, requestEntity,Student.class);
			return responseEntity.getBody();
		}
		catch(RuntimeException e) {
			log.error("Invalid Student Id");
			return null;
		}
	}

	@Override
	public Staff createStaff(Staff staff) {
		log.info("Creating Staff");
		return staffRepository.save(staff);
	}

	@Override
	public Staff updateStaff(Staff staff) {
		if(staffRepository.existsById(staff.getStaffId())) {
			log.info("Updating staff");
			return staffRepository.save(staff);			
		}
		log.error("Invalid StaffId");
		throw new StaffNotFoundException("Provide valid staff Id");
	}

	@Override
	public String deleteStaff(int staffId) {
		if(staffRepository.existsById(staffId)) {
			staffRepository.deleteById(staffId);
			log.info("Staff Deleted");
			return "Staff deleted successfully";
		}
		log.error("Invalid Staff Id");
		throw new StaffNotFoundException("Provide valid staff Id");
	}

	@Override
	public Staff getStaffById(int staffId) {
		if(staffRepository.existsById(staffId)) {
			return staffRepository.findByStaffId(staffId);
		}
		log.error("Invalid Staff Id");
		throw new StaffNotFoundException("Provide valid staff Id");
	}

	@Override
	public List<Staff> getAllStaff() {
		return staffRepository.findAll();
	}

	@Override
	public List<Student> getAllStudents(int staffId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+staffRepository.findByStaffId(staffId).getAuthToken());
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<List<Student>> responseEntity = restTemplate.exchange("http://STUDENT-SERVICE/students",HttpMethod.GET, requestEntity,new ParameterizedTypeReference<List<Student>>() {
			});
		return responseEntity.getBody();
	}

	@Override
	public Staff getStaffByUsername(String username) {
		return staffRepository.findStaffByUsername(username);
	}
}