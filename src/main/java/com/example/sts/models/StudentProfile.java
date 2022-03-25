package com.example.sts.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "studentProfile")
public class StudentProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String dob;
	private String gender;
	private String mobileNumber;
	private String altMobileNumber;
	private String fatherName;
	private String fatherMobile;
	private String motherName;
	private String motherMobile;
	private String permanentAddress;
	private String currentAddress;
	private String class10grade;
	private String class12grade;
	private String currentdegreegrade; 
	private String cpi;
	private String currentBacklogs;
	private String totalBacklogs;
	
	
	  
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "studentProfile")
	
	
}
