package com.mtl.mokolo.batchs.voyagebatch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtl.mokolo.entities.UserEntity;
import com.mtl.mokolo.repositories.UserRepository;

@Component
public class UserItemWriter implements ItemWriter<UserEntity>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void write(List<? extends UserEntity> items) throws Exception {
		userRepository.saveAll(items);
		
	}

}
