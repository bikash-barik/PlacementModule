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

import com.example.sts.models.ApplyJob;
import com.example.sts.models.Company;
import com.example.sts.models.JobDrive;
import com.example.sts.repository.ApplyJobRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/applyjob")
public class ApplyJobController {
	
	@Autowired
	private ApplyJobRepository applyjobRepository;
	
	// get all applyjob
			@GetMapping("/applyjobs")
			@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
			public List<ApplyJob> getAllJobDrive(){
				return applyjobRepository.findAll();	
			}	
			
			
			// create rest for apply job/
			@PostMapping("/applyjobs")
			@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
			public ApplyJob createApplyJob(@RequestBody ApplyJob addApplyjob) {
				return applyjobRepository.save(addApplyjob);
			}
			
			
			// get applied student  id rest 
			@GetMapping("/applyjobs/{id}")
			@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
			public ResponseEntity<ApplyJob> getApplyJobById(@PathVariable Integer id) {
				ApplyJob applyJob = applyjobRepository.findById(id)
						.orElseThrow(() -> new RuntimeException("Student is not exist with id :" + id));
				return ResponseEntity.ok(applyJob);
			}
			
			
			// delete applicant from drive rest 
			@DeleteMapping("/applyjobs/{id}")
			@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
			public ResponseEntity<Map<String, Boolean>> deleteApplyJob(@PathVariable Integer id){
				ApplyJob applyjob = applyjobRepository.findById(id)
						.orElseThrow(() -> new RuntimeException("Student not exist with id :" + id));
				
				applyjobRepository.delete(applyjob);
				Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return ResponseEntity.ok(response);
			}
			
			
			// update applicant details rest 
			@PutMapping("/applyjobs/{id}")
			@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
			public ResponseEntity<ApplyJob> updateApplyJob(@PathVariable Integer id, @RequestBody ApplyJob applyJobDetails){
				ApplyJob applyJob =  applyjobRepository.findById(id)
						.orElseThrow(() -> new RuntimeException("Student not exist with id :" + id));
				
				applyJob.setComName(applyJobDetails.getComName());
				applyJob.setName(applyJobDetails.getName());
				applyJob.setRegdNo(applyJobDetails.getRegdNo());
				applyJob.setEmailId(applyJobDetails.getEmailId());
				
				ApplyJob updatedApplyJob = applyjobRepository.save(applyJob);
				return ResponseEntity.ok(updatedApplyJob);
			}


}
