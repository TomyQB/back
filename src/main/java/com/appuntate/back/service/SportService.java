package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getSportsNames() {
        List<String> names = new ArrayList<>();
        
        List<Sport> sports = sportRepository.findAll();
        for (Sport sport : sports) {
            if(!names.contains(sport.getName()))
                names.add(sport.getName());
        }

        return names;
    }
    
}
