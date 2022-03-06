package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.NotAvailableReservationForbiddenException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationIdNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationUserNotFoundException;
import com.appuntate.back.exceptionHandler.exceptions.notFound.UserIdNotFoundException;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.reservation.ReservationCenterResponseDTO;
import com.appuntate.back.model.dto.reservation.ReservationDTO;
import com.appuntate.back.model.dto.reservation.ReservationUserResponseDTO;
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
    public ConfirmationOutputMap madeReservation(@RequestBody ReservationDTO reservationDTO) throws NotAvailableReservationForbiddenException {
        return reservationService.saveReservation(reservationDTO);
    }

    @DeleteMapping("/cancelReservation/{reservationId}")
    public ConfirmationOutputMap cancelReservation(@PathVariable long reservationId) throws ReservationIdNotFoundException {
        return reservationService.deleteReservation(reservationId);
    }

    @GetMapping("/getUserReservations/{userId}")
    public List<ReservationUserResponseDTO> getReservationByUser(@PathVariable long userId) throws ReservationUserNotFoundException {
        return reservationService.getReservationsByUser(userId);
    }
    
    // @PostMapping("/getCenterReservations")
    // public List<CenterReservationDTO> getReservationByCenter(@RequestBody long centerId) {
    //     return reservationService.getReservationsByCenter(centerId);
    // }

}
