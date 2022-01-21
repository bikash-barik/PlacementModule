package com.example.sts.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "eligibilitycriteria")
public class EligibilityCriteria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String class10grade;
	private String class12grade;
	private String currentdegreegrade;
	private String cpi;
	private String currentBacklogs;
	private String totalBacklogs;


}
