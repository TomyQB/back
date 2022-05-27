package com.appuntate.back.mapper.reservation;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.mapper.center.CenterPhotoMapper;
import com.appuntate.back.mapper.timeInterval.TimeIntervalMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.model.dto.reservation.ReservationResponseDTO;
import com.appuntate.back.service.HourConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationResponseMapper implements IMapper<Reservation, ReservationResponseDTO> {

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Autowired
    private CenterPhotoMapper centerPhotoMapper;

    @Override
    public ReservationResponseDTO entityToDTO(Reservation entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reservation DtoToEntity(ReservationResponseDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ReservationResponseDTO> entitiesToDTOs(List<Reservation> entity) {
        List<ReservationResponseDTO> userReservationsDTO = new ArrayList<>();

        for (Reservation reservation : entity) {
            ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO();

            reservationResponseDTO.setReservationId(reservation.getReservationId());
            reservationResponseDTO.setCourtId(reservation.getCourt().getCourtId());
            reservationResponseDTO.setCourtName(reservation.getCourt().getName());
            reservationResponseDTO.setCenterName(reservation.getCourt().getSport().getCenter().getName());
            reservationResponseDTO.setDate(reservation.getDate());
            reservationResponseDTO.setDuration(HourConverter.hourToDurationString(reservation.getCourt().getInterval()));
            reservationResponseDTO.setPaid(reservation.isPaid());
            reservationResponseDTO.setTimeInterval(timeIntervalMapper.entityToDTO(reservation.getTimeInterval()));
            // userReservationDTO.setCenterPhoto(centerPhotoMapper.entityToDTO(reservation.getCourt().getSport().getCenter().getPhotos().get(0)));
            reservationResponseDTO.setCenterId(reservation.getCourt().getSport().getCenter().getCenterId());
            reservationResponseDTO.setUserName(reservation.getUser().getUserName());

            userReservationsDTO.add(reservationResponseDTO);
        }

        return userReservationsDTO;
    }

    @Override
    public List<Reservation> DtosToEntities(List<ReservationResponseDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
