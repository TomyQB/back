package com.appuntate.back.mapper;

public abstract class AbstractMapper<E, D> {

    public abstract D entityToDTO(E entity);

    public abstract E DtoToEntity(D dto);
    
}
