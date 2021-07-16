package com.mtl.mokolo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtl.mokolo.entities.VoyageEntity;
import com.mtl.mokolo.repositories.VoyageRepository;

@RestController
@RequestMapping(value = "/voyages")
@CrossOrigin(origins = "http://localhost:3000")
public class VoyageController {
	
	@Autowired
	private VoyageRepository voyageRepository;
	
	@GetMapping("/allVoyages")
	public List<VoyageEntity> getAllVoyages(){
		return voyageRepository.findAll();
	}

}
