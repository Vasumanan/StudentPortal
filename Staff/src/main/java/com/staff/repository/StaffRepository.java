package com.staff.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.staff.entity.Staff;

/**
 * This StaffRepository is used to hold Staff details.
 * 
 * @author Vasumanan J
 *
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{
	public Staff findByStaffId(int staffId);
	
	@Query("select staff from Staffs Where staff.username=:username and staff.password=:password")
	public Staff findByUsernameAndPassword(String username , String password);

	@Query("select staff from Staffs Where staff.username=:username")
	public Staff findStaffByUsername(String username);
}