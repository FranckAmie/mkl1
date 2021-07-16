package com.mtl.mokolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mtl.mokolo.entities.UserEntity;
import com.mtl.mokolo.entities.VilleEntity;
import com.mtl.mokolo.entities.VoyageEntity;
import com.mtl.mokolo.repositories.UserRepository;
import com.mtl.mokolo.repositories.VilleRepository;
import com.mtl.mokolo.repositories.VoyageRepository;

@SpringBootApplication
public class MtlappApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private VoyageRepository voyageRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MtlappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Create Users
		UserEntity franckamie = userRepository.save(new UserEntity(null, "NSIMI", "Amie", "franckamie@yahoo.fr", "0628752916", "AD"));
		UserEntity anne = userRepository.save(new UserEntity(null, "OYONO", "Anne", "anne@yahoo.fr", "0628752916", "CL"));
		UserEntity sledge = userRepository.save(new UserEntity(null, "ESSOMA", "Sledge", "sledge@yahoo.fr", "0628752916","CL"));
		UserEntity eva = userRepository.save(new UserEntity(null, "EDZIMBI", "Eva", "eva@yahoo.fr", "0628752916","CL"));
		UserEntity joanna = userRepository.save(new UserEntity(null, "FOUDA", "Joanna", "joanna@yahoo.fr", "0628752916", "CL"));
		
		//Creation des villes
		VilleEntity yaounde = villeRepository.save(new VilleEntity(null, "yde", "Yaoundé", "Cameroun", "cm"));
		VilleEntity paris = villeRepository.save(new VilleEntity(null, "paris", "Paris", "France", "fr"));
		VilleEntity douala = villeRepository.save(new VilleEntity(null, "dla", "Douala", "Cameroun", "cm"));
		VilleEntity londres = villeRepository.save(new VilleEntity(null, "londres", "Londres", "Angleterre", "en"));


		// Création de voyages
		voyageRepository.save(new VoyageEntity(null, yaounde, paris, "10h30", "18h00", joanna));
		voyageRepository.save(new VoyageEntity(null, paris, yaounde, "10h30", "18h00", franckamie));
		voyageRepository.save(new VoyageEntity(null, yaounde, yaounde, "10h30", "18h00", anne));
		voyageRepository.save(new VoyageEntity(null, paris, yaounde, "10h30", "18h00", eva));
		voyageRepository.save(new VoyageEntity(null, londres, yaounde, "10h30", "18h00", sledge));
		voyageRepository.save(new VoyageEntity(null, douala, yaounde, "10h30", "18h00", sledge));


	}

}
