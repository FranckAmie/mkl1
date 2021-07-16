package com.mtl.mokolo.batchs.voyagebatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.mtl.mokolo.entities.UserEntity;

@Component //pour que ce soit un composant Spring au démarrage il représente un composant
public class UserItemProcessor implements ItemProcessor<UserEntity, UserEntity> {

	@Override
	public UserEntity process(UserEntity item) throws Exception {
		item.setRole("PP");
		return item;
	}

}
