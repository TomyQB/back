package com.appuntate.back.mapper.reservation;

import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.model.dto.reservation.ReservationDTO;
import com.appuntate.back.service.CourtService;
import com.appuntate.back.service.TimeIntervalService;
import com.appuntate.back.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper implements IMapper<Reservation, ReservationDTO> {

    @Autowired
    private CourtService courtService;

    @Autowired
    private TimeIntervalService timeIntervalService;

    @Autowired
    private UserService userService;

    @Override
    public ReservationDTO entityToDTO(Reservation entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reservation DtoToEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();

        reservation.setDate(dto.getPlayDate());
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setPaid(dto.isPaid());
        reservation.setCourt(courtService.getCourtByCodCourt(dto.getCourtId()));
        reservation.setTimeInterval(timeIntervalService.getTimeIntervalByCodTimeInterval(dto.getTimeIntervalId()));
        reservation.setUser(userService.getUserByUserId(dto.getDniUser()));

        return reservation;
    }

    @Override
    public List<ReservationDTO> entitiesToDTOs(List<Reservation> entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Reservation> DtosToEntities(List<ReservationDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
