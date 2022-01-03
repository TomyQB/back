package com.appuntate.back.mapper;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.Booking;
import com.appuntate.back.model.dto.UserBookingsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookingMapper implements Mapper<List<Booking>, List<UserBookingsDTO>> {

    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Override
    public List<UserBookingsDTO> entityToDTO(List<Booking> entity) {
        List<UserBookingsDTO> userBookingsDTO = new ArrayList<>();

        for (Booking booking : entity) {
            UserBookingsDTO userBookingDTO = new UserBookingsDTO();

            userBookingDTO.setCodCourt(booking.getCourt().getCodCourt());
            userBookingDTO.setBookingDate(booking.getBookingDate());
            userBookingDTO.setCodBooking(booking.getCodBooking());
            userBookingDTO.setDate(booking.getDate());
            userBookingDTO.setCourtName(booking.getCourt().getName());
            userBookingDTO.setPaid(booking.isPaid());
            userBookingDTO.setTimeInterval(timeIntervalMapper.entityToDTO(booking.getTimeInterval()));

            userBookingsDTO.add(userBookingDTO);
        }

        return userBookingsDTO;
    }

    @Override
    public List<Booking> DtoToEntity(List<UserBookingsDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
