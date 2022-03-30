package com.appuntate.back.service.criteria;

import com.appuntate.back.model.criteria.EventCriteria;
import com.appuntate.back.model.dto.event.EventFilterDTO;

import org.springframework.stereotype.Service;

import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

@Service
public class EventCriteriaService implements ICriteriaService<EventCriteria, EventFilterDTO> {

    @Override
    public EventCriteria createCriteria(EventFilterDTO filterDTO) {
        EventCriteria eventCriteria = new EventCriteria();
        
        if(filterDTO != null) {
            eventCriteria = addUserFilter(eventCriteria, filterDTO);
            eventCriteria = addSportFilter(eventCriteria, filterDTO);
            eventCriteria = addLatitudeFilter(eventCriteria, filterDTO);
            eventCriteria = addLongitudeFilter(eventCriteria, filterDTO);
        }

        return eventCriteria;
    }

    private EventCriteria addUserFilter(EventCriteria eventCriteria, EventFilterDTO filterDTO) {
        
        if(filterDTO.getUserId() != 0) {
            LongFilter filter = new LongFilter();
            filter.setEquals(filterDTO.getUserId());
            eventCriteria.setUserId(filter);
        }

        return eventCriteria;
    }
        
    private EventCriteria addSportFilter(EventCriteria eventCriteria, EventFilterDTO filterDTO) {
        
        if(filterDTO.getSport() != null) {
            StringFilter filter = new StringFilter();
            filter.setEquals(filterDTO.getSport());
            eventCriteria.setSport(filter);
        }

        return eventCriteria;
    }
            
    private EventCriteria addLatitudeFilter(EventCriteria eventCriteria, EventFilterDTO filterDTO) {
        
        if(filterDTO.getLatitude() != null) {
            
            DoubleFilter filter = new DoubleFilter();
            filter.setGreaterThanOrEqual(filterDTO.getLatitude() - 0.14);
            filter.setLessThanOrEqual(filterDTO.getLatitude() + 0.14);
            eventCriteria.setLatitude(filter);
        }

        return eventCriteria;
    }
            
    private EventCriteria addLongitudeFilter(EventCriteria eventCriteria, EventFilterDTO filterDTO) {
        
        if(filterDTO.getLongitude() != null) {
            
            DoubleFilter filter = new DoubleFilter();
            filter.setGreaterThanOrEqual(filterDTO.getLongitude() - 0.125);
            filter.setLessThanOrEqual(filterDTO.getLongitude() + 0.125);
            eventCriteria.setLongitude(filter);
        }

        return eventCriteria;
    }
}
