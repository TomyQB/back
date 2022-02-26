package com.appuntate.back.service.criteria;

import com.appuntate.back.model.criteria.CenterCriteria;
import com.appuntate.back.model.dto.center.CenterFilterDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.stereotype.Service;

import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;

@Service
public class CenterCriteriaService implements CriteriaService<CenterCriteria, CenterFilterDTO> {

    @Override
    public CenterCriteria createCriteria(CenterFilterDTO filterDTO) {
        CenterCriteria centerCriteria = new CenterCriteria();

        if(centerCriteria != null) {
            centerCriteria = addSportFilter(centerCriteria, filterDTO);
            centerCriteria = addHourFilter(centerCriteria, filterDTO);
            centerCriteria = addRatingFilter(centerCriteria, filterDTO);
            centerCriteria = addLatitudeFilter(centerCriteria, filterDTO);
            centerCriteria = addLongitudeFilter(centerCriteria, filterDTO);
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
        
    private CenterCriteria addRatingFilter(CenterCriteria centerCriteria, CenterFilterDTO filterDTO) {
        
        if(filterDTO.getRating() != null) {            
            DoubleFilter filter = new DoubleFilter();
            filter.setGreaterThanOrEqual(filterDTO.getRating());
            centerCriteria.setRating(filter);
        }

        return centerCriteria;
    }
        
    private CenterCriteria addLatitudeFilter(CenterCriteria centerCriteria, CenterFilterDTO filterDTO) {
        
        if(filterDTO.getLatitude() != null) {
            
            DoubleFilter filter = new DoubleFilter();
            filter.setGreaterThanOrEqual(filterDTO.getLatitude() - 0.14);
            filter.setLessThanOrEqual(filterDTO.getLatitude() + 0.14);
            centerCriteria.setLatitude(filter);
        }

        return centerCriteria;
    }
            
    private CenterCriteria addLongitudeFilter(CenterCriteria centerCriteria, CenterFilterDTO filterDTO) {
        
        if(filterDTO.getLongitude() != null) {
            
            DoubleFilter filter = new DoubleFilter();
            filter.setGreaterThanOrEqual(filterDTO.getLongitude() - 0.125);
            filter.setLessThanOrEqual(filterDTO.getLongitude() + 0.125);
            centerCriteria.setLongitude(filter);
        }

        return centerCriteria;
    }
    
    
}
