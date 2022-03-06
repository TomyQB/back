package com.appuntate.back.mapper;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.NotAvailableReservationForbiddenException;


public interface IMapper<E, D> {

    public D entityToDTO(E entity);
    public E DtoToEntity(D dto) throws NotAvailableReservationForbiddenException;
    
    public List<D> entitiesToDTOs(List<E> entities);
    public List<E> DtosToEntities(List<D> dtos);
    
}
