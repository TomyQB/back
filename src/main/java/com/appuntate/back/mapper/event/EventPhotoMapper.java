package com.appuntate.back.mapper.event;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.NotAvailableReservationForbiddenException;
import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.EventPhoto;

import org.springframework.stereotype.Service;

@Service
public class EventPhotoMapper implements IMapper<EventPhoto, String> {

    @Override
    public String entityToDTO(EventPhoto entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EventPhoto DtoToEntity(String dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> entitiesToDTOs(List<EventPhoto> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<EventPhoto> DtosToEntities(List<String> dtos) {
        List<EventPhoto> eventPhotos = new ArrayList<>();

        for (String photo : dtos) {
            EventPhoto eventPhoto = new EventPhoto();
            eventPhoto.setPhoto(photo);
            eventPhotos.add(eventPhoto);
        }
        return eventPhotos;
    }
    
}
