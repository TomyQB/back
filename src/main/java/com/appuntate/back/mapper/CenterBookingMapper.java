package com.appuntate.back.mapper;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.model.Booking;
import com.appuntate.back.model.dto.CenterBookingsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterBookingMapper implements Mapper<List<Booking>, List<CenterBookingsDTO>> {
    
    @Autowired
    private TimeIntervalMapper timeIntervalMapper;

    @Override
    public List<CenterBookingsDTO> entityToDTO(List<Booking> entity) {
        List<CenterBookingsDTO> centerBookingsDTO = new ArrayList<>();

        for (Booking booking : entity) {
            CenterBookingsDTO centerBookingDTO = new CenterBookingsDTO();

            centerBookingDTO.setBookingDate(booking.getBookingDate());
            centerBookingDTO.setCodBooking(booking.getCodBooking());
            centerBookingDTO.setDate(booking.getDate());
            centerBookingDTO.setCourtName(booking.getCourt().getName());
            centerBookingDTO.setPaid(booking.isPaid());
            centerBookingDTO.setTimeInterval(timeIntervalMapper.entityToDTO(booking.getTimeInterval()));
            centerBookingDTO.setUserName(booking.getUser().getName() + " " + booking.getUser().getLastName());


            centerBookingsDTO.add(centerBookingDTO);
        }

        return centerBookingsDTO;
    }

    @Override
    public List<Booking> DtoToEntity(List<CenterBookingsDTO> dto) {
        // TODO Auto-generated method stub
        return null;
    }


    
}
