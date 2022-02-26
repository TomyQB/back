package com.appuntate.back.mapper.reservation;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.model.dto.reservation.UserReservationResponseDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationUserMapper implements IMapper<Reservation, UserReservationResponseDTO> {

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Override
    public UserReservationResponseDTO entityToDTO(Reservation entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reservation DtoToEntity(UserReservationResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserReservationResponseDTO> entitiesToDTOs(List<Reservation> entity) {
        List<UserReservationResponseDTO> userReservationsDTO = new ArrayList<>();

        for (Reservation reservation : entity) {
            UserReservationResponseDTO userReservationDTO = new UserReservationResponseDTO();

            userReservationDTO.setReservationId(reservation.getReservationId());
            userReservationDTO.setCourtId(reservation.getCourt().getCourtId());
            userReservationDTO.setCourtName(reservation.getCourt().getName());
            userReservationDTO.setCenterName(reservation.getCourt().getSport().getCenter().getName());
            userReservationDTO.setDate(reservation.getDate());
            userReservationDTO.setDuration(HourConverter.hourToString(reservation.getCourt().getInterval()));
            userReservationDTO.setPaid(reservation.isPaid());
            userReservationDTO.setTimeInterval(timeIntervalMapper.entityToDTO(reservation.getTimeInterval()));

            userReservationsDTO.add(userReservationDTO);
        }

        return userReservationsDTO;
    }

    @Override
    public List<Reservation> DtosToEntities(List<UserReservationResponseDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
