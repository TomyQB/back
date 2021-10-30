package com.appuntate.back.mapper;

public interface Mapper<E, D> {

    public D entityToDTO(E entity);

    public E DtoToEntity(D dto);
    
}
