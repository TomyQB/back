package com.appuntate.back.service.criteria;

import com.appuntate.back.model.Court;
import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.model.dto.CourtFilterDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.stereotype.Service;

import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

@Service
public class CourtCriteriaService implements CriteriaService<CourtCriteria, CourtFilterDTO> {

    @Override
    public CourtCriteria createCriteria(CourtFilterDTO filterDTO) {
        CourtCriteria courtCriteria = new CourtCriteria();

        if(courtCriteria != null) {
            courtCriteria = addTownFilter(courtCriteria, filterDTO);
            courtCriteria = addSportFilter(courtCriteria, filterDTO);
            courtCriteria = addHourFilter(courtCriteria, filterDTO);
            courtCriteria = addValorationFilter(courtCriteria, filterDTO);
        }

        return courtCriteria;
    }

    private CourtCriteria addTownFilter(CourtCriteria courtCriteria, CourtFilterDTO filterDTO) {

        if(filterDTO.getTown() != null) {
            StringFilter filter = new StringFilter();
            filter.setEquals(filterDTO.getTown());
            courtCriteria.setTown(filter);
        }

        return courtCriteria;
    }
    
    private CourtCriteria addSportFilter(CourtCriteria courtCriteria, CourtFilterDTO filterDTO) {
        
        if(filterDTO.getSport() != null) {
            StringFilter filter = new StringFilter();
            filter.setEquals(filterDTO.getSport());
            courtCriteria.setSport(filter);
        }

        return courtCriteria;
    }
    
    private CourtCriteria addHourFilter(CourtCriteria courtCriteria, CourtFilterDTO filterDTO) {
        
        if(filterDTO.getHour() != null) {
            int hour = HourConverter.stringToHour(filterDTO.getHour());
            
            
            IntegerFilter filter = new IntegerFilter();
            filter.setGreaterThanOrEqual(hour);
            courtCriteria.setHour(filter);
        }

        return courtCriteria;
    }

    private CourtCriteria addValorationFilter(CourtCriteria courtCriteria, CourtFilterDTO filterDTO) {

        if(filterDTO.getValoration() != null) {
            DoubleFilter filter = new DoubleFilter();
            filter.setGreaterThanOrEqual(filterDTO.getValoration());
            courtCriteria.setValoration(filter);
        }

        return courtCriteria;
    }
    
}
