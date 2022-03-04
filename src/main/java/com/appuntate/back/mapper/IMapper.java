package com.appuntate.back.mapper;

import java.util.List;

public interface IMapper<E, D> {

    public D entityToDTO(E entity);
    public E DtoToEntity(D dto);
    
    public List<D> entitiesToDTOs(List<E> entities);
    public List<E> DtosToEntities(List<D> dtos);
    
}
