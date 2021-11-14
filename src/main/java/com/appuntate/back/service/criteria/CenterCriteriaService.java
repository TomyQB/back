package com.appuntate.back.service.criteria;

import com.appuntate.back.model.criteria.CenterCriteria;
import com.appuntate.back.model.dto.CenterFilterDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.stereotype.Service;

import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

@Service
public class CenterCriteriaService implements CriteriaService<CenterCriteria, CenterFilterDTO> {

    @Override
    public CenterCriteria createCriteria(CenterFilterDTO filterDTO) {
        CenterCriteria centerCriteria = new CenterCriteria();

        if(centerCriteria != null) {
            centerCriteria = addTownFilter(centerCriteria, filterDTO);
            centerCriteria = addSportFilter(centerCriteria, filterDTO);
            centerCriteria = addHourFilter(centerCriteria, filterDTO);
        }

        return centerCriteria;
    }
    
    private CenterCriteria addTownFilter(CenterCriteria centerCriteria, CenterFilterDTO filterDTO) {

        if(filterDTO.getTown() != null) {
            StringFilter filter = new StringFilter();
            filter.setEquals(filterDTO.getTown());
            centerCriteria.setTown(filter);
        }

        return centerCriteria;
    }
    
    private CenterCriteria addSportFilter(CenterCriteria centerCriteria, CenterFilterDTO filterDTO) {
        
        if(filterDTO.getSport() != null) {
            StringFilter filter = new StringFilter();
            filter.setEquals(filterDTO.getSport());
            centerCriteria.setSport(filter);
        }

        return centerCriteria;
    }
    
    private CenterCriteria addHourFilter(CenterCriteria centerCriteria, CenterFilterDTO filterDTO) {
        
        if(filterDTO.getHour() != null) {
            int hour = HourConverter.stringToHour(filterDTO.getHour());
            
            IntegerFilter filter = new IntegerFilter();
            filter.setGreaterThanOrEqual(hour);
            centerCriteria.setHour(filter);
        }

        return centerCriteria;
    }
    
    
}
