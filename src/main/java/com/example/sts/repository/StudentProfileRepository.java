package com.example.sts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sts.models.StudentProfile;


@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer>{
//	Optional<StudentProfile> findByUsername(String email);

}
