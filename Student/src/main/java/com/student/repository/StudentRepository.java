
package com.student.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;


/**
 * This StudentRepository is used to hold student details.
 * 
 * @author Vasumanan J
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	public Student findByStudentId(int studentId);
	
	@Query("select student from Students Where student.username=:username and student.password=:password")
	public Student findByUsernameAndPassword(String username , String password);
}
