package com.appuntate.back.repository;


import com.appuntate.back.model.Sport;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
    
    Sport findBySportNameNameAndCenterCenterId(String sportName, long centerId);
}
