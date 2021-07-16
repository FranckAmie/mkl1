package com.mtl.mokolo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtl.mokolo.entities.UserEntity;
import com.mtl.mokolo.repositories.UserRepository;

@RestController
@RequestMapping(value = "/user")
//@CrossOrigin(origins = "http://localhost:3000")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private Job job;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@GetMapping("allUsers")
	@PreAuthorize("hasAuthority('person:read')")
	public List<UserEntity> getAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('person:write')")
	public UserEntity getAllUser(){
		return repository.findAll().get(0);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("runBatchUser")
	public BatchStatus runBatchUser() throws Exception {
		Map<String, JobParameter> params = new HashMap<>();
		JobParameters jobParameter = new JobParameters(params);
		JobExecution execution = jobLauncher.run(job, jobParameter); 
		return execution.getStatus();
	}
	
	
	@PreAuthorize("hasAuthority('person:write')")
	@DeleteMapping(path="personId")
	public void deletePerson(@PathVariable("personId")String perdonId) {
		System.out.println(String.format("Delete effectuée avec succès : %s", perdonId));
	}
	
	
	// @RequestBody pour le Post
	@PreAuthorize("hasAuthority('person:write')")
	@PostMapping()
	public void postPerson(@RequestBody UserEntity user) {
		System.out.println(String.format("Ajout effectuée avec succès : %s", user.getId()));
	}
	
	@PreAuthorize("hasAuthority('person:write')")	
	@PutMapping(path = "personId")
	public void putPerson(@PathVariable("personId") String personId) {
		System.out.println(String.format("Modification effectuée avec succès : %s", personId));
	}
}
