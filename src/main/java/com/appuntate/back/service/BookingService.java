package com.appuntate.back.service;

import java.util.List;

import com.appuntate.back.mapper.BookingMapper;
import com.appuntate.back.mapper.CenterBookingMapper;
import com.appuntate.back.mapper.UserBookingMapper;
import com.appuntate.back.model.Booking;
import com.appuntate.back.model.dto.BookingDTO;
import com.appuntate.back.model.dto.CenterBookingsDTO;
import com.appuntate.back.model.dto.ConfirmationOutputMap;
import com.appuntate.back.model.dto.UserBookingsDTO;
import com.appuntate.back.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private UserBookingMapper userBookingMapper;

    @Autowired
    private CenterBookingMapper centerBookingMapper;


    public ConfirmationOutputMap saveBooking(BookingDTO bookingDTO) {
        ConfirmationOutputMap confirmation = new ConfirmationOutputMap(false, "Error al reservar pista", 0);
        if (isCourtEmpty(bookingDTO)) {
            bookingRepository.save(bookingMapper.DtoToEntity(bookingDTO));
            confirmation.setOk(true);
            confirmation.setMessage("Pista reservada correctamente");
        }
        
        return confirmation;
    }

    private boolean isCourtEmpty(BookingDTO bookingDTO) {
        if (bookingRepository.findByCourtCodCourtAndDateAndTimeIntervalCodTimeInterval(bookingDTO.getCodCourt(),
                bookingDTO.getPlayDate(), bookingDTO.getCodTimeInterval()) != null)
            return false;

        return true;
    }

    public void deleteBooking(long codBooking) {
        bookingRepository.deleteById(codBooking);
    }

    public List<UserBookingsDTO> getBookingsByUser(long userId) {
        List<Booking> bookings = bookingRepository.findByUserCodUsuario(userId);
        return userBookingMapper.entityToDTO(bookings);
    }

    public List<CenterBookingsDTO> getBookingsByCenter(long userId) {
        List<Booking> bookings = bookingRepository.findByCourtSportCenterCodCenter(userId);
        return centerBookingMapper.entityToDTO(bookings);
    }
}
