package dev.patika.e_commerce_project_2.core.config.modelMapper;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
