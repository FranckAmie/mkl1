package com.mtl.mokolo.batchs;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.mtl.mokolo.dto.ReferenceDto;
import com.mtl.mokolo.entities.VilleEntity;

@Configuration // car c'est une classe de configuration
@EnableBatchProcessing // pour activer Spring batch au demarage il cré des objet qu'on peut injecter dans notre programme
public class SpringBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory; 
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	/*@Autowired
	private ItemReader<UserEntity> voyageItemReader;
	@Autowired
	private ItemProcessor<UserEntity, UserEntity> voyageItemProcessor;
	@Autowired
	private ItemWriter<UserEntity> voyageItemWriter;*/
	@Autowired
	private ItemReader<VilleEntity> villeItemReader;
	@Autowired
	private ItemProcessor<VilleEntity, VilleEntity> villeItemProcessor;
	@Autowired
	private ItemWriter<VilleEntity> villeItemWriter;
	
	@Bean
	public Job runVillesJob() {
		Step step = stepBuilderFactory.get("step-load-villes")
				.<VilleEntity, VilleEntity>chunk(100)
				.reader(villeItemReader)
				.processor(villeItemProcessor)
				.writer(villeItemWriter)
				.build(); 
		
		return jobBuilderFactory.get("ville-loader-job").start(step).build();
	}
	@Bean
	public FlatFileItemReader<VilleEntity> flatFileItemReader(@Value("${inputFile}") Resource inputFile){
		FlatFileItemReader<VilleEntity> fileItemReader = new FlatFileItemReader<>();
		fileItemReader.setName("FFIR1");
		fileItemReader.setLinesToSkip(1);
		fileItemReader.setResource(inputFile);
		fileItemReader.setLineMapper(lineMapper());
		return fileItemReader;
	}
	@Bean
	public LineMapper<VilleEntity> lineMapper() {
		DefaultLineMapper<VilleEntity> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setStrict(false);
		delimitedLineTokenizer.setNames("id", "codeVille","nomVille", "nomPays", "codePays");
		lineMapper.setLineTokenizer(delimitedLineTokenizer);
		BeanWrapperFieldSetMapper<VilleEntity> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(VilleEntity.class);
		lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		return lineMapper;
	}
/*@Bean
	public Job runUserJob() {
		Step step = stepBuilderFactory.get("step-load-data")
				.<UserEntity, UserEntity>chunk(100)
				.reader(voyageItemReader)
				.processor(voyageItemProcessor)
				.writer(voyageItemWriter)
				.build(); 
		
		return jobBuilderFactory.get("voyage-loader-job").start(step).build();
	}
	
	@Bean
	public FlatFileItemReader<UserEntity> flatFileItemReader(@Value("${inputFile}") Resource inputFile){
		FlatFileItemReader<UserEntity> fileItemReader = new FlatFileItemReader<>();
		fileItemReader.setName("F1");
		fileItemReader.setLinesToSkip(1);
		fileItemReader.setResource(inputFile);
		fileItemReader.setLineMapper(lineMapper());
		return fileItemReader;
	}
	@Bean
	public LineMapper<UserEntity> lineMapper() {
		DefaultLineMapper<UserEntity> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer(",");
		delimitedLineTokenizer.setStrict(false);
		delimitedLineTokenizer.setNames("idUser","nom", "prenom", "email","telephone", "role");
		lineMapper.setLineTokenizer(delimitedLineTokenizer);
		BeanWrapperFieldSetMapper<UserEntity> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(UserEntity.class);
		lineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		return lineMapper;
	}*/
	
}
