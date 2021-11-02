package com.appuntate.back.mapper;

import com.appuntate.back.model.Booking;
import com.appuntate.back.model.dto.BookingDTO;
import com.appuntate.back.service.CourtService;
import com.appuntate.back.service.TimeIntervalService;
import com.appuntate.back.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper implements Mapper<Booking, BookingDTO> {

    @Autowired
    private CourtService courtService;

    @Autowired
    private TimeIntervalService timeIntervalService;

    @Autowired
    private UserService userService;

    @Override
    public BookingDTO entityToDTO(Booking entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Booking DtoToEntity(BookingDTO dto) {
        Booking booking = new Booking();

        booking.setDate(dto.getPlayDate());
        booking.setBookingDate(dto.getBookingDate());
        booking.setPaid(dto.isPaid());
        booking.setCourt(courtService.getCourtByCodCourt(dto.getCodCourt()));
        booking.setTimeInterval(timeIntervalService.getTimeIntervalByCodTimeInterval(dto.getCodTimeInterval()));
        booking.setUser(userService.getUserByCodUser(dto.getDniUser()));

        return booking;
    }
    
}
