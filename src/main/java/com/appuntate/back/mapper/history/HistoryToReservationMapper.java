package com.appuntate.back.mapper.history;

import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.History;
import com.appuntate.back.model.Reservation;

import org.springframework.stereotype.Service;

@Service
public class HistoryToReservationMapper implements IMapper<History, Reservation> {

    @Override
    public Reservation entityToDTO(History entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public History DtoToEntity(Reservation dto) {
        History history = new History();

        history.setCourt(dto.getCourt());
        history.setDate(dto.getDate());
        history.setPaid(dto.isPaid());
        history.setTimeInterval(dto.getTimeInterval());
        history.setUser(dto.getUser());

        return history;
    }

    @Override
    public List<Reservation> entitiesToDTOs(List<History> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<History> DtosToEntities(List<Reservation> dtos) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
