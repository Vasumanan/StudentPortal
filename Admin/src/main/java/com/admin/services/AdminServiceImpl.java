package com.admin.services;

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

import com.admin.config.JwtProvider;
import com.admin.entity.Admin;
import com.admin.entity.Staff;
import com.admin.exceptions.AdminNotFoundException;
import com.admin.repository.AdminRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This AdminServiceImpl will perform all the Admin related services
 * 
 * @author Vasumanan J
 *
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminServices{

	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public Staff createStaff(Staff staff,int adminId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+adminRepository.findByAdminId(adminId).getAuthToken());
		staff.setRole("STAFF");
		staff.setAuthToken(jwtProvider.generateToken(staff.getUsername()));
		HttpEntity<Staff> entity = new HttpEntity<Staff>(staff,headers);
		log.info("Staff Created");
		return restTemplate.postForObject("http://STAFF-SERVICE/staffs", entity, Staff.class);		
	}

	@Override
	public String updateStaff(int adminId,Staff staff) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+adminRepository.findByAdminId(adminId).getAuthToken());
		HttpEntity<Staff> entity = new HttpEntity<Staff>(staff,headers);
		try {
			restTemplate.exchange("http://STAFF-SERVICE/staffs",HttpMethod.PUT,entity,Staff.class);
		}
		catch(RuntimeException e) {
			log.error("Invalid StaffID");
			return e.getMessage();
		}
		log.info("Staff Updated");
		return "Staff Updated";
	}

	@Override
	public String deleteStaff(int adminId,int staffId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+adminRepository.findByAdminId(adminId).getAuthToken());
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		try {
			 ResponseEntity<String> responseEntity = restTemplate.exchange("http://STAFF-SERVICE/staffs/"+staffId,HttpMethod.DELETE, requestEntity,String.class);
			 log.info("Staff Deleted");
			 return responseEntity.getBody();
		}
		catch(RuntimeException e) {
			log.error("Invalid Staff ID");
			return e.getMessage();
		}
	}

	@Override
	public Staff getStaffById(int adminId,int staffId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+adminRepository.findByAdminId(adminId).getAuthToken());
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		try {
			ResponseEntity<Staff> responseEntity = restTemplate.exchange("http://STAFF-SERVICE/staffs/"+staffId,HttpMethod.GET, requestEntity,Staff.class);
			return responseEntity.getBody();
		}
		
		catch(RuntimeException e) {
			log.error("Invalid Staff Id");
			return null;
		}
	}

	@Override
	public int login(String username, String password) {
		Admin admin = adminRepository.findByUsernameAndPassword(username, password);
		if(admin==null) {
			log.error("Invalid username or password");
			throw new AdminNotFoundException("Invalid username or password");
		}
		return admin.getAdminId();
	}

	@Override
	public List<Staff> getAllStaff(int adminId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer "+adminRepository.findByAdminId(adminId).getAuthToken());
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<List<Staff>> responseEntity = restTemplate.exchange("http://STAFF-SERVICE/staffs/",HttpMethod.GET, requestEntity,new ParameterizedTypeReference<List<Staff>>() {
			});

		return responseEntity.getBody();
	}

	@Override
	public Admin getAdminByUsername(String username) {
		Admin admin=adminRepository.findByUsername(username);
		if(admin==null) {
			log.error("Invalid Username");
			throw new AdminNotFoundException("Invalid Username");
		}
		return admin;
	}

	@Override
	public Admin createAdmin(Admin admin) {
		admin.setRole("ADMIN");
		admin.setAuthToken(jwtProvider.generateToken(admin.getUsername()));
		log.info("Admin Created");
		return adminRepository.save(admin);
	}
}