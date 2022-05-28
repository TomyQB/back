package com.appuntate.back.mapper.event;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.exceptionHandler.exceptions.forbidden.NotAvailableReservationForbiddenException;
import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.EventPhoto;
import com.appuntate.back.model.dto.cloudinary.CloudinaryDTO;
import com.cloudinary.Cloudinary;

import org.springframework.stereotype.Service;

@Service
public class EventPhotoMapper implements IMapper<EventPhoto, CloudinaryDTO> {

    @Override
    public CloudinaryDTO entityToDTO(EventPhoto entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EventPhoto DtoToEntity(CloudinaryDTO dto) {
        EventPhoto eventPhoto = new EventPhoto();

        eventPhoto.setPhoto(dto.getUrl());
        eventPhoto.setEventPhotoId(dto.getImageId());

        return eventPhoto;
    }

    @Override
    public List<CloudinaryDTO> entitiesToDTOs(List<EventPhoto> entities) {
        // List<String> photos = new ArrayList<>();

        // for (EventPhoto eventPhoto : entities) {
        //     String photo = eventPhoto.getPhoto();
        //     photos.add(photo);
        // }
        // return photos;
        return null;
    }

    @Override
    public List<EventPhoto> DtosToEntities(List<CloudinaryDTO> dtos) {
        // List<EventPhoto> eventPhotos = new ArrayList<>();

        // for (String photo : dtos) {
        //     EventPhoto eventPhoto = new EventPhoto();
        //     eventPhoto.setPhoto(photo);
        //     eventPhotos.add(eventPhoto);
        // }
        // return eventPhotos;
        return null;
    }
    
}
