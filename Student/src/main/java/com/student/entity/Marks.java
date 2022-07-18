package com.student.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int markId;
	private int englishMark,mathsMark,socialMark,tamilMark,scienceMark;
	private int total;
	private double percentage;
	
}