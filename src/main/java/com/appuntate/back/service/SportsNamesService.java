package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.mapper.SportsNamesMapper;
import com.appuntate.back.model.dto.SportsNamesDTO;
import com.appuntate.back.repository.SportsNamesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsNamesService {

    @Autowired
    private SportsNamesRepository sportsNamesRepository;

    @Autowired
    private SportsNamesMapper sportsNamesMapper;

    public List<SportsNamesDTO> getSportsNames() {
        return sportsNamesMapper.entityToDTO(sportsNamesRepository.findAll());
    }
    
}
