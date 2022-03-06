package com.appuntate.back.mapper.court;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.TimeInterval;
import com.appuntate.back.model.dto.court.CourtResponseDTO;

import org.springframework.stereotype.Service;

@Service
public class CourtResponseMapper implements IMapper<TimeInterval, CourtResponseDTO> {

    @Override
    public CourtResponseDTO entityToDTO(TimeInterval entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TimeInterval DtoToEntity(CourtResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourtResponseDTO> entitiesToDTOs(List<TimeInterval> entities) {
        List<CourtResponseDTO> courtResponseDTOs = new ArrayList<>();

        for (TimeInterval timeInterval : entities) {
            CourtResponseDTO courtResponseDTO = new CourtResponseDTO();

            courtResponseDTO.setCourtId(timeInterval.getCourt().getCourtId());
            courtResponseDTO.setName(timeInterval.getCourt().getName());

            courtResponseDTOs.add(courtResponseDTO);
        }

        return courtResponseDTOs;
    }

    @Override
    public List<TimeInterval> DtosToEntities(List<CourtResponseDTO> dtos) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
