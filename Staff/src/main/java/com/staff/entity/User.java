/**
 * 
 */
package com.staff.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vajanart
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String login;
	private String password;
	private String role;
}
