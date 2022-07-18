package com.staff.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vajanart
 *
 */
@Entity
@Table (name= "Staffs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staffId;
	@NotEmpty(message = "Please provide firstname")
	private String firstname;
	@NotEmpty(message = "Please provide lastname")
	private String lastname;
	@NotEmpty(message = "Please provide username")
	private String username;
	@NotEmpty(message = "Please provide password")
	private String password;
    @Email(message = "Please provide valid email Id")
	private String emailId;
	private String role;
	private String authToken;
}
