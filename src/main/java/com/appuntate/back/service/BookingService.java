package com.appuntate.back.service;

import com.appuntate.back.mapper.BookingMapper;
import com.appuntate.back.model.dto.BookingDTO;
import com.appuntate.back.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    public void saveBooking(BookingDTO bookingDTO) {
        if(isCourtEmpty(bookingDTO))
            bookingRepository.save(bookingMapper.DtoToEntity(bookingDTO));
    }

    private boolean isCourtEmpty(BookingDTO bookingDTO) {
        if(bookingRepository.findByCourtCodCourtAndDateAndTimeIntervalCodTimeInterval
            (bookingDTO.getCodCourt(), bookingDTO.getPlayDate(), bookingDTO.getCodTimeInterval()) != null)
                return false;

        return true;
    }

    public void deleteBooking(long codBooking) {
        bookingRepository.deleteById(codBooking);
    }
    
}
