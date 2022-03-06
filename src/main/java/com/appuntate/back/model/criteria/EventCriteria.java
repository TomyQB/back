package com.appuntate.back.model.criteria;

import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;

@Data
public class EventCriteria {
    
    private StringFilter sport;
    private DoubleFilter latitude;
    private DoubleFilter longitude;
    
}
