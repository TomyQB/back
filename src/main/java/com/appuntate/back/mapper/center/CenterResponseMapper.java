package com.appuntate.back.mapper.center;

import java.util.List;
import java.util.Objects;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.Center;
import com.appuntate.back.model.dto.center.CenterResponseDTO;

import org.springframework.stereotype.Service;

@Service
public class CenterResponseMapper implements IMapper<Center, CenterResponseDTO>{


    @Override
    public CenterResponseDTO entityToDTO(Center entity) {
        if(Objects.isNull(entity)) return null;

        CenterResponseDTO centerResponseDTO = new CenterResponseDTO();

        centerResponseDTO.setCenterId(entity.getCenterId());
        centerResponseDTO.setPhoto(entity.getPhotos().get(0).getPhoto());
        centerResponseDTO.setName(entity.getName());
        centerResponseDTO.setMinimumPrice(entity.getMinimumPrice());
        centerResponseDTO.setLatitude(entity.getLatitude());
        centerResponseDTO.setRating(entity.getRating());
        centerResponseDTO.setLongitude(entity.getLongitude());

        return centerResponseDTO;
    }

    @Override
    public Center DtoToEntity(CenterResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CenterResponseDTO> entitiesToDTOs(List<Center> entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Center> DtosToEntities(List<CenterResponseDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
