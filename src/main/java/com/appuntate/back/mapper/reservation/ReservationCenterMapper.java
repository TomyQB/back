package com.appuntate.back.mapper.reservation;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.model.dto.reservation.ReservationCenterResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationCenterMapper implements IMapper<Reservation, ReservationCenterResponseDTO> {
    
    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Override
    public ReservationCenterResponseDTO entityToDTO(Reservation entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reservation DtoToEntity(ReservationCenterResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ReservationCenterResponseDTO> entitiesToDTOs(List<Reservation> entity) {
        List<ReservationCenterResponseDTO> centerReservationsDTO = new ArrayList<>();

        for (Reservation reservation : entity) {
            ReservationCenterResponseDTO centerReservationDTO = new ReservationCenterResponseDTO();

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
    public List<Reservation> DtosToEntities(List<ReservationCenterResponseDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }


    
}
