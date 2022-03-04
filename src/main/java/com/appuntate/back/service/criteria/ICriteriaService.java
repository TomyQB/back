package com.appuntate.back.service.criteria;

public interface ICriteriaService<C, D> {

    public C createCriteria(D filterDTO);
    
}
