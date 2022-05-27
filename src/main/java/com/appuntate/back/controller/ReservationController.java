package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.CourtAlreadyReservedForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.forbidden.NotAvailableReservationForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationCourtNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationUserNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.reservation.ReservationDTO;
import com.appuntate.back.model.dto.reservation.ReservationResponseDTO;
import com.appuntate.back.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PutMapping("/makeReservation")
    public ConfirmationOutputMap makeReservation(@RequestBody ReservationDTO reservationDTO) throws NotAvailableReservationForbiddenException, CourtAlreadyReservedForbiddenException {
        return reservationService.saveReservation(reservationDTO);
    }

    @DeleteMapping("/deleteReservation/{reservationId}")
    public ConfirmationOutputMap cancelReservation(@PathVariable long reservationId) throws ReservationIdNotFoundException {
        return reservationService.deleteReservation(reservationId);
    }

    @GetMapping("/getUserReservations/{userId}")
    public List<ReservationResponseDTO> getReservationByUser(@PathVariable long userId) throws ReservationUserNotFoundException {
        return reservationService.getReservationsByUser(userId);
    }

    @GetMapping("/getCenterReservations/{courtId}")
    public List<ReservationResponseDTO> getReservationByCourt(@PathVariable long courtId) throws ReservationCourtNotFoundException {
        return reservationService.getReservationsByCourt(courtId);
    }

    @PostMapping("/checkAvailableModification")
    public ConfirmationOutputMap checkAvailableModification(@RequestBody ReservationDTO reservationDTO) {
        return reservationService.checkAvailableModification(reservationDTO);
    }

    @PutMapping("/modifyReservation/{reservationId}")
    public ConfirmationOutputMap modifyReservation(@PathVariable long reservationId, @RequestBody ReservationDTO reservationDTO) throws ReservationIdNotFoundException, NotAvailableReservationForbiddenException, CourtAlreadyReservedForbiddenException {
        reservationService.deleteReservation(reservationId);
        return reservationService.saveReservation(reservationDTO);
    }

}
