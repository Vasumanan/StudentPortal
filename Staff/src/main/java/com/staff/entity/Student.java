/**
 * 
 */
package com.staff.entity;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;


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
public class Student {

	private int studentId;
	private String username;
    private String password;
	private String firstname;
    private String lastname;
    private int classNo;
    private char section;
    @OneToOne(cascade = CascadeType.ALL)
	private Marks marks;

}