package com.mtl.mokolo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtl.mokolo.dto.ReferenceDto;
import com.mtl.mokolo.entities.VilleEntity;
import com.mtl.mokolo.repositories.VilleRepository;

@RestController
@RequestMapping("/references")
@CrossOrigin("http://localhost:3000")
public class ReferenceController {
	
	@Autowired
	private VilleRepository villeRepository;
	
	@GetMapping("allVilles")
	public List<ReferenceDto> getAllVilles() {
		List<VilleEntity> allVilles = villeRepository.findAll();
		return allVilles.stream().map(v -> new ReferenceDto(v.getId(), v.getNomVille())).collect(Collectors.toList());
	}

}
