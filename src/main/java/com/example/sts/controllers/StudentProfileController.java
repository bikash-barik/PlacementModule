package com.example.sts.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.sts.models.StudentProfile;
import com.example.sts.repository.StudentProfileRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/studentprofile")
public class StudentProfileController {
	
	@Autowired
	private StudentProfileRepository studentProfileRepository;
	
	
	// get all student
		@GetMapping("/studens")
		@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
		public List<StudentProfile> getAllCompanies(){
			return studentProfileRepository.findAll();	
		}	
		
		// create rest for add student/
			@PostMapping("/students")
			@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
			public StudentProfile createStudentProffile(@RequestBody StudentProfile addStudent) {
				return studentProfileRepository.save(addStudent);
			}
			
			
			// get student profile by id rest api
			@GetMapping("/students/{id}")
			@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
			public ResponseEntity<StudentProfile> getStudentProfileById(@PathVariable Integer id) {
				StudentProfile studentprofile = studentProfileRepository.findById(id)
						.orElseThrow(() -> new RuntimeException("Student not exist with id :" + id));
				return ResponseEntity.ok(studentprofile);
			}
			
			// update STUDENT PROFILE rest api
			@PutMapping("/students/{id}")
			@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
			public ResponseEntity<StudentProfile> updateCompany(@PathVariable Integer id, @RequestBody StudentProfile studentProfileDetails){
				StudentProfile studentProfile = studentProfileRepository.findById(id)
						.orElseThrow(() -> new RuntimeException("Student not exist with id :" + id));
				
				studentProfile.setFirstName(studentProfileDetails.getFirstName());
				studentProfile.setMiddleName(studentProfileDetails.getMiddleName());
				studentProfile.setLastName(studentProfileDetails.getLastName());
				studentProfile.setEmail(studentProfileDetails.getEmail());
				studentProfile.setDob(studentProfileDetails.getDob());
				studentProfile.setGender(studentProfileDetails.getGender());
				studentProfile.setMobileNumber(studentProfileDetails.getMobileNumber());
				studentProfile.setAltMobileNumber(studentProfileDetails.getAltMobileNumber());
				studentProfile.setFatherName(studentProfileDetails.getFatherName());
				studentProfile.setFatherMobile(studentProfileDetails.getFatherMobile());
				studentProfile.setMotherName(studentProfileDetails.getMotherName());
				studentProfile.setMotherMobile(studentProfileDetails.getMotherMobile());
				studentProfile.setPermanentAddress(studentProfileDetails.getPermanentAddress());
				studentProfile.setCurrentAddress(studentProfileDetails.getCurrentAddress());
				studentProfile.setClass10grade(studentProfileDetails.getClass10grade());
				studentProfile.setClass12grade(studentProfileDetails.getClass12grade());
				studentProfile.setCurrentdegreegrade(studentProfileDetails.getCurrentdegreegrade());
				studentProfile.setCpi(studentProfileDetails.getCpi());
				studentProfile.setCurrentBacklogs(studentProfileDetails.getCurrentBacklogs());
				studentProfile.setTotalBacklogs(studentProfileDetails.getTotalBacklogs());
				
				
				
				StudentProfile updatedStudentProfile = studentProfileRepository.save(studentProfile);
				return ResponseEntity.ok(updatedStudentProfile);
			}
			
			
			
			
			// delete student profile rest api
			@DeleteMapping("/students/{id}")
			@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
			public ResponseEntity<Map<String, Boolean>> deleteStudentProfile(@PathVariable Integer id){
				StudentProfile studentprofile = studentProfileRepository.findById(id)
						.orElseThrow(() -> new RuntimeException("Student not exist with id :" + id));
				
				studentProfileRepository.delete(studentprofile);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}

}
