package com.appuntate.back.model.criteria;

import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;

@Data
public class CourtCriteria {
        
    private LongFilter centerId;
    private StringFilter date;
    private IntegerFilter hour;
    private StringFilter sport;
}
