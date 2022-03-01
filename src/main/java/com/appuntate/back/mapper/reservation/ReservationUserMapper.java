package com.appuntate.back.mapper.reservation;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.model.dto.reservation.ReservationUserResponseDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationUserMapper implements IMapper<Reservation, ReservationUserResponseDTO> {

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Override
    public ReservationUserResponseDTO entityToDTO(Reservation entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reservation DtoToEntity(ReservationUserResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ReservationUserResponseDTO> entitiesToDTOs(List<Reservation> entity) {
        List<ReservationUserResponseDTO> userReservationsDTO = new ArrayList<>();

        for (Reservation reservation : entity) {
            ReservationUserResponseDTO userReservationDTO = new ReservationUserResponseDTO();

            userReservationDTO.setReservationId(reservation.getReservationId());
            userReservationDTO.setCourtId(reservation.getCourt().getCourtId());
            userReservationDTO.setCourtName(reservation.getCourt().getName());
            userReservationDTO.setCenterName(reservation.getCourt().getSport().getCenter().getName());
            userReservationDTO.setDate(reservation.getDate());
            userReservationDTO.setDuration(HourConverter.hourToDurationString(reservation.getCourt().getInterval()));
            userReservationDTO.setPaid(reservation.isPaid());
            userReservationDTO.setTimeInterval(timeIntervalMapper.entityToDTO(reservation.getTimeInterval()));

            userReservationsDTO.add(userReservationDTO);
        }

        return userReservationsDTO;
    }

    @Override
    public List<Reservation> DtosToEntities(List<ReservationUserResponseDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
