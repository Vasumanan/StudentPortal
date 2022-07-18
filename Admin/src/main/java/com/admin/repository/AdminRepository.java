
package com.admin.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.admin.entity.Admin;


/**
 * This AdminRepository is used to hold admin details.
 * 
 * @author Vasumanan J
 *
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

	@Query("select admin from Admins Where admin.username=:username and admin.password=:password")
	public Admin findByUsernameAndPassword(String username , String password);
	
	@Query(value = "Select admin from Admins admin where admin.username=:username")
	public Admin findByUsername(String username);
	
	public Admin findByAdminId(int adminId);
}
