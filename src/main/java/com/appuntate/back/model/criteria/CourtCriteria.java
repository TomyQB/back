package com.appuntate.back.model.criteria;

import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;

@Data
public class CourtCriteria {
    
    private StringFilter town;
    private StringFilter sport;
    private StringFilter hour;
    
}
