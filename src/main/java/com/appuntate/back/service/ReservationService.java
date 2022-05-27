package com.appuntate.back.service;

import java.util.List;
import java.util.Objects;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.CourtAlreadyReservedForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.forbidden.NotAvailableReservationForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationCourtNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationUserNotFoundException;
import com.appuntate.back.mapper.reservation.ReservationMapper;
import com.appuntate.back.mapper.reservation.ReservationResponseMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.reservation.ReservationDTO;
import com.appuntate.back.model.dto.reservation.ReservationResponseDTO;
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
    private ReservationResponseMapper userReservationMapper;

    @Autowired
    private TimeIntervalService timeIntervalService;


    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public ConfirmationOutputMap saveReservation(ReservationDTO reservationDTO) throws NotAvailableReservationForbiddenException, CourtAlreadyReservedForbiddenException {
        if(timeIntervalService.getAvailableTimeIntervalByCenterId(reservationDTO.getCenterId(), reservationDTO.getHour(), reservationDTO.getDate()).isEmpty() ||
            checkReservationAlreadyExist(reservationDTO))
            throw new CourtAlreadyReservedForbiddenException(reservationDTO.getCourtId());

        Reservation reservation = reservationMapper.DtoToEntity(reservationDTO);
        if(Objects.isNull(reservation.getTimeInterval())) throw new NotAvailableReservationForbiddenException(reservationDTO.getDate(), reservationDTO.getHour());
        reservationRepository.save(reservation);
        return new ConfirmationOutputMap(true, "Pista reservada correctamente");
    }

    private boolean checkReservationAlreadyExist(ReservationDTO reservationDTO) {
        return reservationRepository.findByCourtCourtIdAndDateAndTimeIntervalStartHour
                                    (reservationDTO.getCourtId(), reservationDTO.getDate(), HourConverter.stringToHour(reservationDTO.getHour())) != null
                                    ? true : false;
    }

    public ConfirmationOutputMap deleteReservation(long reservationId) throws ReservationIdNotFoundException {
        try {
            reservationRepository.deleteById(reservationId);
            return new ConfirmationOutputMap(true, "Reserva cancelada correctamente");
        } catch(EmptyResultDataAccessException e) {
            throw new ReservationIdNotFoundException(Long.toString(reservationId));
        }
    }

    public List<ReservationResponseDTO> getReservationsByUser(long userId) throws ReservationUserNotFoundException {
        List<Reservation> reservations = reservationRepository.findByUserUserId(userId);

        if(reservations.isEmpty()) throw new ReservationUserNotFoundException(Long.toString(userId));
        return userReservationMapper.entitiesToDTOs(reservations);

    }

    public List<ReservationResponseDTO> getReservationsByCourt(long centerId) throws ReservationCourtNotFoundException {
        List<Reservation> reservations = reservationRepository.findByCourtCourtId(centerId);

        if(reservations.isEmpty()) throw new ReservationCourtNotFoundException(Long.toString(centerId));
        return userReservationMapper.entitiesToDTOs(reservations);
    }

    public ConfirmationOutputMap checkAvailableModification(ReservationDTO reservationDTO) {
        if(timeIntervalService.getAvailableTimeIntervalByCenterId(reservationDTO.getCenterId(), reservationDTO.getHour(), reservationDTO.getDate()).isEmpty() ||
            checkReservationAlreadyExist(reservationDTO))
            return new ConfirmationOutputMap(false, "Cambio de reserva no disponible");

        return new ConfirmationOutputMap(true, "Cambio de reserva disponible");
    }

}
