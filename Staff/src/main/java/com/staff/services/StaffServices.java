package com.staff.services;

import java.util.List;

import com.staff.entity.Staff;
import com.staff.entity.Student;

/**
 * This StaffService will perform all the Staff related services
 * 
 * @author Vasumanan J
 *
 */
public interface StaffServices {
	
	public int login (String username , String password);

	/**
	 * This createSaff method will Save the Staff in the Database.
	 * 
	 * @param staff it is the object of Staff which is to be added in database.
	 * @return This method will return Staff object if it is saved in database.
	 */
	public Staff createStaff(Staff staff);
	
	/**
	 * This updateStaff method is used to update staff in the database.
	 * 
	 * @param staff it is the Staff object which is to be updated in the database.
	 * @return This method will return updated Staff object from the database.
	 */
	public Staff updateStaff(Staff staff);
	
	/**
	 * This deleteStaff method is used to delete the Staff from the database.
	 * 
	 * @param staffId it is the Id of Staff which is to be remove from database.
	 * @return This method will return message if deleted.StaffNotFoundException
	 *         in case there is no Staff in database.
	 */
	public String deleteStaff(int staffId);
	
	/**
	 * This getStaffById method is used to get the Staff by Id from the
	 * database.
	 * 
	 * @param staffId it is the Id of Staff which is to be read in Database.
	 * @return This method will return Staff object if it
	 *         found.StaffNotFoundException in case there is no Staff in
	 *         database.
	 */
	public Staff getStaffById(int staffId);
	
	/**
	 * This getAllStaff method is used to get Staff list from the database.
	 * @return This method will return Staff list from the database.
	 */
	public List<Staff> getAllStaff();
	
	/**
	 * This getStaffByUsername method is used to get Student from the database.
	 * @param username it is the username of the staff to fetch from the database.
	 * @return This method will return Student from the database.
	 */
	public Staff getStaffByUsername(String username);

	/**
	 * This createStudent method will Save the Student in the Database.
	 * 
	 * @param staffId it is the id of the staff who is creating the Student.
	 * @param student it is the object of Student which is to be added in database.
	 * @return This method will return Student object if it is saved in database.
	 */
	public Student createStudent (int staffId, Student student);

	/**
	 * This updateStudent method is used to update student in the database.
	 * 
	 * @param staffId it is the id of the staff who is updating the Student
	 * @param manager it is the Manager object which is to be updated in the database.
	 * @return This method will return updated Student object from the database.
	 */
	public String updateStudent(int staffId, Student student);

	/**
	 * This deleteStudent method is used to delete the Student from the database.
	 * 
	 * @param staffId it is the id of the staff who is deleting the Student
	 * @param studentId it is the Id of Student which is to be remove from database.
	 * @return This method will return message if deleted.StudentNotFoundException
	 *         in case there is no Student in database.
	 */
	public String deleteStudent(int staffId, int studentId);

	/**
	 * This getStudentById method is used to get the Student by Id from the
	 * database.
	 * 
	 * @param staffId it is the id of the staff who is fetching the Student
	 * @param studentId it is the Id of Student which is to be read in Database.
	 * @return This method will return Student object if it
	 *         found.StudentNotFoundException in case there is no Student in
	 *         database.
	 */
	public Student getStudentById(int staffId, int studentId);

	/**
	 * This getAllStudents method is used to get Students list from the database.
	 * @param staffId it is the id of the staff who is fetching the Student
	 * @return This method will return Students list from the database.
	 */
	public List<Student> getAllStudents(int staffId);

}