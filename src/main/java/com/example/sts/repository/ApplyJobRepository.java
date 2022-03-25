package com.example.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sts.models.ApplyJob;

@Repository
public interface ApplyJobRepository extends JpaRepository<ApplyJob, Integer>{

}
