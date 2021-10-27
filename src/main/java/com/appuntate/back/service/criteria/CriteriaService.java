package com.appuntate.back.service.criteria;

public interface CriteriaService<C, D> {

    public C createCriteria(D filterDTO);
    
}
