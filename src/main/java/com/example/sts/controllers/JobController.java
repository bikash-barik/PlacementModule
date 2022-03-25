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


import com.example.sts.models.JobDrive;

import com.example.sts.repository.JobDriveRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/addjob")
public class JobController {
	
	
	@Autowired
	private JobDriveRepository jobdriveRepository;
	
	// get all jobs
		@GetMapping("/jobs")
		@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
		public List<JobDrive> getAllJobDrive(){
			return jobdriveRepository.findAll();	
		}	
		
		
		// create rest for add job drive
				@PostMapping("/jobs")
				@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
				public JobDrive createJobDrive(@RequestBody JobDrive jobdrive) {
					return jobdriveRepository.save(jobdrive);
				}
				
				
				// get job drive by id rest 
				@GetMapping("/jobs/{id}")
				@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
				public ResponseEntity<JobDrive> getJobDriveById(@PathVariable Integer id) {
					JobDrive jobdrive = jobdriveRepository.findById(id)
							.orElseThrow(() -> new RuntimeException("Student not exist with id :" + id));
					return ResponseEntity.ok(jobdrive);
				}
				
				
				// delete job drive rest 
				@DeleteMapping("/jobs/{id}")
				@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
				public ResponseEntity<Map<String, Boolean>> deleteJobDrive(@PathVariable Integer id){
					JobDrive jobdrive = jobdriveRepository.findById(id)
							.orElseThrow(() -> new RuntimeException("Student not exist with id :" + id));
					
					jobdriveRepository.delete(jobdrive);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
				}
				
				// update job drive rest 
				@PutMapping("/jobs/{id}")
				@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
				public ResponseEntity<JobDrive> updateCompany(@PathVariable Integer id, @RequestBody JobDrive jobdriveDetails){
					JobDrive jobdrive = jobdriveRepository.findById(id)
							.orElseThrow(() -> new RuntimeException("Student not exist with id :" + id));
					
					jobdrive.setComName(jobdriveDetails.getComName());
					jobdrive.setJobType(jobdriveDetails.getJobType());
					jobdrive.setJobSalary(jobdriveDetails.getJobSalary());
					jobdrive.setJobVacancy(jobdriveDetails.getJobVacancy());
					jobdrive.setJobDate(jobdriveDetails.getJobDate());
					jobdrive.setJobRound(jobdriveDetails.getJobRound());
					jobdrive.setJobCriteria(jobdriveDetails.getJobCriteria());
					jobdrive.setJobDescription(jobdriveDetails.getJobDescription());
					JobDrive updatedJobDrive = jobdriveRepository.save(jobdrive);
					return ResponseEntity.ok(updatedJobDrive);
				}
}
