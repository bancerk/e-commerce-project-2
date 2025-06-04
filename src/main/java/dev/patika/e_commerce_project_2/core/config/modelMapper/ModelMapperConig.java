package dev.patika.e_commerce_project_2.core.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
