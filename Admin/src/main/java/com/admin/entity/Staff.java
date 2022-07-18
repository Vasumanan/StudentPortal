/**
 * 
 */
package com.admin.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vajanart
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	private int staffId;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String emailId;
	private String role;
	private String authToken;
}