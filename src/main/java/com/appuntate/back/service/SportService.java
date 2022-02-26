package com.appuntate.back.service;


import com.appuntate.back.model.Sport;
import com.appuntate.back.repository.SportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    public Sport getSportById(long sportId) {
        return sportRepository.getById(sportId);
    }

    public Sport getSportBySportNameAndCodCenter(String sportName, long centerId) {
        return sportRepository.findBySportsNamesNameAndCenterCenterId(sportName, centerId);
    }
    
}
