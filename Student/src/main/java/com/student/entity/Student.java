/**
 * 
 */
package com.student.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vajanart
 *
 */
@Entity
@Table(name="Students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	@NotEmpty(message = "Please provide username")
	private String username;
	@NotEmpty(message = "Please provide password")
    private String password;
	@NotEmpty(message = "Please provide firstname")
	private String firstname;
	@NotEmpty(message = "Please provide lastname")
    private String lastname;
	@NotEmpty(message = "Please provide class no")
    private int classNo;
	@NotEmpty(message = "Please provide section")
    private char section;
    @OneToOne(cascade = CascadeType.ALL)
	private Marks marks;
 
}