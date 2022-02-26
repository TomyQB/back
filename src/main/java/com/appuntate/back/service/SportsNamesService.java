package com.appuntate.back.service;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.sportNames.SportsNamesMapper;
import com.appuntate.back.model.dto.sportName.SportsNamesResponseDTO;
import com.appuntate.back.repository.SportsNamesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsNamesService {

    @Autowired
    private SportsNamesRepository sportsNamesRepository;

    @Autowired
    private SportsNamesMapper sportsNamesMapper;

    private static List<SportsNamesResponseDTO> instanceSingleton = new ArrayList<>();

    public List<SportsNamesResponseDTO> getSportsNames() {
        if(instanceSingleton != null)
            instanceSingleton = sportsNamesMapper.entitiesToDTOs(sportsNamesRepository.findAll());
        
        return instanceSingleton;
    }
    
}
