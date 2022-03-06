package com.appuntate.back.mapper.center;

import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.sport.SportMapper;
import com.appuntate.back.model.Center;
import com.appuntate.back.model.dto.center.CenterCompleteResponseDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterCompleteResponseMapper implements IMapper<Center, CenterCompleteResponseDTO> {

    @Autowired
    private SportMapper sportMapper;

    @Override
    public CenterCompleteResponseDTO entityToDTO(Center entity) {
        CenterCompleteResponseDTO centerCompleteResponseDTO = new CenterCompleteResponseDTO();

        centerCompleteResponseDTO.setCenterId(entity.getCenterId());
        centerCompleteResponseDTO.setName(entity.getName());
        centerCompleteResponseDTO.setAdress(entity.getAdress());
        centerCompleteResponseDTO.setLatitude(entity.getLatitude());
        centerCompleteResponseDTO.setLongitude(entity.getLongitude());
        centerCompleteResponseDTO.setRating(entity.getRating());
        centerCompleteResponseDTO.setOpeningHour(HourConverter.hourToString(entity.getStartHour()));
        centerCompleteResponseDTO.setClosingHour(HourConverter.hourToString(entity.getEndHour()));
        centerCompleteResponseDTO.setImage(entity.getImage());
        centerCompleteResponseDTO.setCenterSports(sportMapper.entitiesToDTOs(entity.getSports()));

        return centerCompleteResponseDTO;
    }

    @Override
    public Center DtoToEntity(CenterCompleteResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CenterCompleteResponseDTO> entitiesToDTOs(List<Center> entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Center> DtosToEntities(List<CenterCompleteResponseDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public CenterCompleteResponseDTO entityToDTONotReserved(Center entity, String date) {
        CenterCompleteResponseDTO centerCompleteResponseDTO = new CenterCompleteResponseDTO();

        centerCompleteResponseDTO.setCenterId(entity.getCenterId());
        centerCompleteResponseDTO.setName(entity.getName());
        centerCompleteResponseDTO.setAdress(entity.getAdress());
        centerCompleteResponseDTO.setLatitude(entity.getLatitude());
        centerCompleteResponseDTO.setLongitude(entity.getLongitude());
        centerCompleteResponseDTO.setRating(entity.getRating());
        centerCompleteResponseDTO.setOpeningHour(HourConverter.hourToString(entity.getStartHour()));
        centerCompleteResponseDTO.setClosingHour(HourConverter.hourToString(entity.getEndHour()));
        centerCompleteResponseDTO.setImage(entity.getImage());
        centerCompleteResponseDTO.setCenterSports(sportMapper.entitiesToDTOsNotReserved(entity.getSports(), date));

        return centerCompleteResponseDTO;
    }
    
}
