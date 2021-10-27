package com.appuntate.back.service.criteria;

import com.appuntate.back.model.criteria.CourtCriteria;
import com.appuntate.back.model.dto.CourtFilterDTO;

import org.springframework.stereotype.Service;

import io.github.jhipster.service.filter.StringFilter;

@Service
public class CourtCriteriaService implements CriteriaService<CourtCriteria, CourtFilterDTO> {

    public CourtCriteria createCriteria(CourtFilterDTO filterDTO) {
        CourtCriteria courtCriteria = new CourtCriteria();

        if(courtCriteria != null) {
            courtCriteria = addTownFilter(courtCriteria, filterDTO);
            courtCriteria = addSportFilter(courtCriteria, filterDTO);
            courtCriteria = addHourFilter(courtCriteria, filterDTO);
        }

        return courtCriteria;
    }

    private CourtCriteria addTownFilter(CourtCriteria courtCriteria, CourtFilterDTO filterDTO) {

        if(filterDTO.getTown() != null) {
            StringFilter filter = new StringFilter();
            filter.setContains(filterDTO.getTown());
            courtCriteria.setTown(filter);
        }

        return courtCriteria;
    }
    
    private CourtCriteria addSportFilter(CourtCriteria courtCriteria, CourtFilterDTO filterDTO) {
        
        if(filterDTO.getSport() != null) {
            StringFilter filter = new StringFilter();
            filter.setContains(filterDTO.getSport());
            courtCriteria.setSport(filter);
        }

        return courtCriteria;
    }
    
    private CourtCriteria addHourFilter(CourtCriteria courtCriteria, CourtFilterDTO filterDTO) {
        
        if(filterDTO.getHour() != null) {
            StringFilter filter = new StringFilter();
            filter.setContains(filterDTO.getHour());
            courtCriteria.setHour(filter);
        }

        return courtCriteria;
    }
    
}
