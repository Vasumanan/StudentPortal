package com.admin.services;


import java.util.List;
import com.admin.entity.Admin;
import com.admin.entity.Staff;
/**
 * This AdminService will perform all the Admin related services
 * 
 * @author Vasumanan J
 *
 */
public interface AdminServices {
	
	public int login(String username , String password); 
	
	/**
	 * This createAdmin method will Save the Admin in the Database.
	 * 
	 * @param admin it is the object of Admin which is to be added in database.
	 * @return This method will return Admin object if it is saved in database.
	 */
	public Admin createAdmin(Admin admin);
	
	/**
	 * This getAdminByUsername method will return the Admin with the given username.
	 * 
	 * @param username it is the username of the admin whom details you need to fetch from database.
	 * @return This method will return Admin object.
	 */
	public Admin getAdminByUsername(String username); 
	
	/**
	 * This createSaff method will Save the Staff in the Database.
	 * 
	 * @param staff it is the object of Staff which is to be added in database.
	 * @return This method will return Staff object if it is saved in database.
	 */
	public Staff createStaff(Staff staff,int adminId);

	/**
	 * This updateStaff method is used to update staff in the database.
	 * 
	 * @param staff it is the Staff object which is to be updated in the database.
	 * @return This method will return updated Staff object from the database.
	 */
	public String updateStaff(int adminId, Staff staff);

	/**
	 * This deleteStaff method is used to delete the Staff from the database.
	 * 
	 * @param staffId it is the Id of Staff which is to be remove from database.
	 * @return This method will return message if deleted.StaffNotFoundException
	 *         in case there is no Staff in database.
	 */
	public String deleteStaff(int adminId, int staffId);

	/**
	 * This getStaffById method is used to get the Staff by Id from the
	 * database.
	 * 
	 * @param staffId it is the Id of Staff which is to be read in Database.
	 * @return This method will return Staff object if it
	 *         found.StaffNotFoundException in case there is no Staff in
	 *         database.
	 */
	public Staff getStaffById(int adminId,int staffId);
	
	/**
	 * This getAllStaff method is used to get Staff list from the database.
	 * @return This method will return Staff list from the database.
	 */
	public List<Staff> getAllStaff(int adminId);

}
