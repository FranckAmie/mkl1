package com.mtl.mokolo.batchs.villebatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.mtl.mokolo.entities.VilleEntity;
@Component
public class VilleItemProcessor implements ItemProcessor<VilleEntity, VilleEntity> {

	@Override
	public VilleEntity process(VilleEntity item) throws Exception {
		return item;
	}

}
