package com.appuntate.back.controller;

import com.appuntate.back.model.dto.BookingDTO;
import com.appuntate.back.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/makeBooking")
    public void madeBooking(@RequestBody String s) {
        BookingDTO bookingDTO = new BookingDTO("02/11/2021", "03/11/2021", true, 32, 3, 1);
        bookingService.saveBooking(bookingDTO);
    }

    @PostMapping("/cancelBooking")
    public void cancelBooking(@RequestBody long codBooking) {
        bookingService.deleteBooking(1);
    }
    
}
