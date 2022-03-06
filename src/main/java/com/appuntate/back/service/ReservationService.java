package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.NotAvailableReservationForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationUserNotFoundException;
import com.appuntate.back.mapper.reservation.ReservationCenterMapper;
import com.appuntate.back.mapper.reservation.ReservationMapper;
import com.appuntate.back.mapper.reservation.ReservationUserMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.reservation.ReservationCenterResponseDTO;
import com.appuntate.back.model.dto.reservation.ReservationDTO;
import com.appuntate.back.model.dto.reservation.ReservationUserResponseDTO;
import com.appuntate.back.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private ReservationUserMapper userReservationMapper;

    @Autowired
    private ReservationCenterMapper centerReservationMapper;


    public ConfirmationOutputMap saveReservation(ReservationDTO reservationDTO) throws NotAvailableReservationForbiddenException {
        Reservation reservation = reservationMapper.DtoToEntity(reservationDTO);
        if(reservation.getTimeInterval() == null) throw new NotAvailableReservationForbiddenException(reservationDTO.getDate(), reservationDTO.getHour());
        reservationRepository.save(reservation);
        return new ConfirmationOutputMap(true, "Pista reservada correctamente");
    }

    public ConfirmationOutputMap deleteReservation(long reservationId) throws ReservationIdNotFoundException {
        try {
            reservationRepository.deleteById(reservationId);
            return new ConfirmationOutputMap(true, "Reserva cancelada correctamente");
        } catch(EmptyResultDataAccessException e) {
            throw new ReservationIdNotFoundException(Long.toString(reservationId));
        }
    }

    public List<ReservationUserResponseDTO> getReservationsByUser(long userId) throws ReservationUserNotFoundException {
        List<Reservation> reservations = reservationRepository.findByUserUserId(userId);

        if(reservations.isEmpty()) throw new ReservationUserNotFoundException(Long.toString(userId));
        return userReservationMapper.entitiesToDTOs(reservations);

    }

    public List<ReservationCenterResponseDTO> getReservationsByCenter(long userId) {
        List<Reservation> reservations = reservationRepository.findByCourtSportCenterCenterId(userId);
        return centerReservationMapper.entitiesToDTOs(reservations);
    }
}
