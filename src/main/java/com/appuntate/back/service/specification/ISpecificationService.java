package com.appuntate.back.service.specification;

import org.springframework.data.jpa.domain.Specification;

public interface ISpecificationService<E, C> {
    
    public Specification<E> createSpecification(C criteria);

}
