package com.appuntate.back.mapper.history;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.center.CenterPhotoMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.History;
import com.appuntate.back.model.dto.history.HistoryUserResponseDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryUserMapper implements IMapper<History, HistoryUserResponseDTO> {

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Autowired
    private CenterPhotoMapper centerPhotoMapper;
    

    @Override
    public HistoryUserResponseDTO entityToDTO(History entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public History DtoToEntity(HistoryUserResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<HistoryUserResponseDTO> entitiesToDTOs(List<History> entities) {
        List<HistoryUserResponseDTO> userHistoryDTO = new ArrayList<>();

        for (History history : entities) {
            HistoryUserResponseDTO userReservationDTO = new HistoryUserResponseDTO();

            userReservationDTO.setReservationId(history.getHistoryId());
            userReservationDTO.setCourtId(history.getCourt().getCourtId());
            userReservationDTO.setCourtName(history.getCourt().getName());
            userReservationDTO.setCenterName(history.getCourt().getSport().getCenter().getName());
            userReservationDTO.setDate(history.getDate());
            userReservationDTO.setDuration(HourConverter.hourToDurationString(history.getCourt().getInterval()));
            userReservationDTO.setPaid(history.isPaid());
            userReservationDTO.setTimeInterval(timeIntervalMapper.entityToDTO(history.getTimeInterval()));
            userReservationDTO.setCenterPhoto(centerPhotoMapper.entityToDTO(history.getCourt().getSport().getCenter().getPhotos().get(0)));
            userReservationDTO.setCenterId(history.getCourt().getSport().getCenter().getCenterId());

            userHistoryDTO.add(userReservationDTO);
        }

        return userHistoryDTO;
    } 

    @Override
    public List<History> DtosToEntities(List<HistoryUserResponseDTO> dtos) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
