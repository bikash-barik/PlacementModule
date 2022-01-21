package com.example.sts.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "companyevent")
public class CompanyEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nameCom;
	private String regStartDate;
	private String regEndDate;
//	private Set<EligibilityCriteria> eligibilityCriteria = new HashSet<>();
//	private List eligibilityCriteria; 
	private String jobDescription;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(	name = "companyevent_eligibilitycriteria", 
//				joinColumns = @JoinColumn(name = "companyevent_id"), 
//				inverseJoinColumns = @JoinColumn(name = "eligibilitycriteria_id"))

}
