package com.appuntate.back.mapper.center;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.model.dto.center.CenterReservationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterReservationMapper implements IMapper<Reservation, CenterReservationDTO> {
    
    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Override
    public CenterReservationDTO entityToDTO(Reservation entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reservation DtoToEntity(CenterReservationDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CenterReservationDTO> entitiesToDTOs(List<Reservation> entity) {
        List<CenterReservationDTO> centerReservationsDTO = new ArrayList<>();

        for (Reservation reservation : entity) {
            CenterReservationDTO centerReservationDTO = new CenterReservationDTO();

            centerReservationDTO.setReservationDate(reservation.getReservationDate());
            centerReservationDTO.setReservationId(reservation.getReservationId());
            centerReservationDTO.setDate(reservation.getDate());
            centerReservationDTO.setCourtName(reservation.getCourt().getName());
            centerReservationDTO.setPaid(reservation.isPaid());
            centerReservationDTO.setTimeInterval(timeIntervalMapper.entityToDTO(reservation.getTimeInterval()));
            centerReservationDTO.setUserName(reservation.getUser().getName() + " " + reservation.getUser().getLastName());


            centerReservationsDTO.add(centerReservationDTO);
        }

        return centerReservationsDTO;
    }

    @Override
    public List<Reservation> DtosToEntities(List<CenterReservationDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }


    
}
