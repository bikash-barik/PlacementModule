package com.example.sts.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EligibilityCriteria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String tenthMark;
	private String twelveMark;
	private String technicalSkill;
	private String currentMark;
	private String description;


}
