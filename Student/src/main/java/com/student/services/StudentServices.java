package com.student.services;

import java.util.List;
import com.student.entity.Student;

/**
 * This StudentService will perform all the Student related services
 * 
 * @author Vasumanan J
 *
 */
public interface StudentServices {
	
	/**
	 * This createStudent method will Save the Student in the Database.
	 * 
	 * @param student it is the object of Student which is to be added in database.
	 * @return This method will return Student object if it is saved in database.
	 */
	public Student createStudent (Student student);
	
	/**
	 * This updateStudent method is used to update student in the database.
	 * 
	 * @param manager it is the Manager object which is to be updated in the database.
	 * @return This method will return updated Student object from the database.
	 */
	public Student updateStudent(Student student) ;
	
	/**
	 * This deleteStudent method is used to delete the Student from the database.
	 * 
	 * @param studentId it is the Id of Student which is to be remove from database.
	 * @return This method will return message if deleted.StudentNotFoundException
	 *         in case there is no Student in database.
	 */
	public String deleteStudent(int studentId);
	
	/**
	 * This getStudentById method is used to get the Student by Id from the
	 * database.
	 * 
	 * @param studentId it is the Id of Student which is to be read in Database.
	 * @return This method will return Student object if it
	 *         found.StudentNotFoundException in case there is no Student in
	 *         database.
	 */
	public Student getStudentById(int studentId);

	/**
	 * This getAllStudents method is used to get Students list from the database.
	 * 
	 * @return This method will return Students list from the database.
	 */
	public List<Student> getAllStudents();
	
	/**
	 * This login method is used for student login.
	 * @param username it is the username of Student which is to be read in Database.
	 * @param password it is the password of Student which is to be read in Database.
	 * @return This method will return the id of the Student.
	 */
	public int login(String username, String password);
}
