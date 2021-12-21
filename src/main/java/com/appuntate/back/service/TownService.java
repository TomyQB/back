package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.mapper.TownMapper;
import com.appuntate.back.repository.TownRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownService {

    @Autowired
    private TownRepository townRepository;

    @Autowired
    private TownMapper townMapper;

    public List<String> getTowns() {
        return townMapper.entityToDTO(townRepository.findAll());
    }

}
