package com.ettakip.EtTakip;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtTakipApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtTakipApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration() .setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

}
