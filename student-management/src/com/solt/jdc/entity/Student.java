package com.solt.jdc.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Student {
	
	private int id;
	private String name;
	private Gender gender;
	private LocalDate dob;
	private String phone;
	
	private Classroom classroom;

	public enum Gender { Male, Female }
}
