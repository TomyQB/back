package com.appuntate.back.service.criteria;

import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.model.dto.center.CenterFilterDTO;
import com.appuntate.back.model.dto.court.CourtRequestDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.stereotype.Service;

import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

@Service
public class CourtCriteriaService implements ICriteriaService<CourtCriteria, CourtRequestDTO> {

    @Override
    public CourtCriteria createCriteria(CourtRequestDTO filterDTO) {
        CourtCriteria courtCriteria = new CourtCriteria();

        if(filterDTO != null) {
            courtCriteria = addCenterIdFilter(courtCriteria, filterDTO);
            courtCriteria = addDateFilter(courtCriteria, filterDTO);
            courtCriteria = addHourFilter(courtCriteria, filterDTO);
            courtCriteria = addSportFilter(courtCriteria, filterDTO);
        }

        return courtCriteria;
    }

    private CourtCriteria addCenterIdFilter(CourtCriteria courtCriteria, CourtRequestDTO filterDTO) {
        
        if(filterDTO.getCenterId() != 0) {
            LongFilter filter = new LongFilter();
            filter.setEquals(filterDTO.getCenterId());
            courtCriteria.setCenterId(filter);
        }

        return courtCriteria;
    }

    private CourtCriteria addDateFilter(CourtCriteria courtCriteria, CourtRequestDTO filterDTO) {
        
        if(filterDTO.getDate() != null) {
            StringFilter filter = new StringFilter();
            filter.setEquals(filterDTO.getDate());
            courtCriteria.setDate(filter);
        }

        return courtCriteria;
    }

    private CourtCriteria addHourFilter(CourtCriteria courtCriteria, CourtRequestDTO filterDTO) {
        
        if(filterDTO.getHour() != null) {
            IntegerFilter filter = new IntegerFilter();
            filter.setGreaterThanOrEqual(HourConverter.stringToHour(filterDTO.getHour()));
            courtCriteria.setHour(filter);
        }

        return courtCriteria;
    }

    private CourtCriteria addSportFilter(CourtCriteria courtCriteria, CourtRequestDTO filterDTO) {
        
        if(filterDTO.getSport() != null) {
            StringFilter filter = new StringFilter();
            filter.setEquals(filterDTO.getSport());
            courtCriteria.setSport(filter);
        }

        return courtCriteria;
    }
    

}
