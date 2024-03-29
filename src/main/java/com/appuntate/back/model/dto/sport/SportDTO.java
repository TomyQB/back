package com.appuntate.back.model.dto.sport;

import java.util.List;

import com.appuntate.back.model.dto.court.CourtDTO;
import com.appuntate.back.model.dto.sportName.SportsNamesResponseDTO;

import lombok.Data;

@Data
public class SportDTO {

    private long sportId;
    private String name;
    private String photo;
    private List<CourtDTO> courts;
    
}
