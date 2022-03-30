package com.appuntate.back.cron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.notFound.ReservationIdNotFoundException;
import com.appuntate.back.mapper.history.HistoryToReservationMapper;
import com.appuntate.back.model.Reservation;
import com.appuntate.back.service.HistoryService;
import com.appuntate.back.service.HourConverter;
import com.appuntate.back.service.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ReservationCron {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HistoryToReservationMapper historyToReservationMapper;
    
    private static final long MINUTO = 1000 * 60;

    @Scheduled(fixedDelay = MINUTO * 5)
    public void deletePastReservations() throws ReservationIdNotFoundException {
        System.out.println("HOLA");
        List<Reservation> reservations = reservationService.getAllReservations();
        
        for (Reservation reservation : reservations) {
            if(checkPastReservation(reservation)) {
                reservationService.deleteReservation(reservation.getReservationId());
                historyService.save(historyToReservationMapper.DtoToEntity(reservation));
            }
        }
    }
    
    private boolean checkPastReservation(Reservation reservation) {
        if(HourConverter.stringToDate(reservation.getDate()).isBefore(LocalDate.now())
            || (HourConverter.stringToDate(reservation.getDate()).isEqual(LocalDate.now())
            && reservation.getTimeInterval().getStartHour() < HourConverter.dateToHour(LocalDateTime.now().toString())))
            return true;

        return false;
        
    }

    @Scheduled(cron = "0 0 2 1 * ?")
    public void saveIntoHistory() {
        historyService.deleteAll();
    }
}
