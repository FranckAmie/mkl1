package com.mtl.mokolo.batchs.villebatch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtl.mokolo.entities.VilleEntity;
import com.mtl.mokolo.repositories.VilleRepository;

@Component
public class VilleItemWriter implements ItemWriter<VilleEntity>{

	@Autowired
	private VilleRepository villeRepository;
	@Override
	public void write(List<? extends VilleEntity> items) throws Exception {
		villeRepository.saveAll(items);
	}

}
