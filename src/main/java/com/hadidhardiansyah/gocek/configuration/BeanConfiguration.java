package com.hadidhardiansyah.gocek.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
