package com.appuntate.back.controller;

import java.util.List;

import com.appuntate.back.model.dto.BookingDTO;
import com.appuntate.back.model.dto.CenterBookingsDTO;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.UserBookingsDTO;
import com.appuntate.back.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/makeBooking")
    public ConfirmationOutputMap madeBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.saveBooking(bookingDTO);
    }

    @PostMapping("/cancelBooking")
    public void cancelBooking(@RequestBody long codBooking) {
        bookingService.deleteBooking(codBooking);
    }

    @PostMapping("/getUserBookings")
    public List<UserBookingsDTO> getBookingByUser(@RequestBody long userId) {
        return bookingService.getBookingsByUser(userId);
    }
    
    @PostMapping("/getCenterBookings/{centerId}")
    public List<CenterBookingsDTO> getBookingByCenter(@PathVariable long centerId) {
        return bookingService.getBookingsByCenter(centerId);
    }

}
