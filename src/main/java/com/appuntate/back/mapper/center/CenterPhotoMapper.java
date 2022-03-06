package com.appuntate.back.mapper.center;

import java.util.ArrayList;
import java.util.List;

import com.appuntate.back.mapper.IMapper;
import com.appuntate.back.model.CenterPhoto;

import org.springframework.stereotype.Service;

@Service
public class CenterPhotoMapper implements IMapper<CenterPhoto, String> {

    @Override
    public String entityToDTO(CenterPhoto entity) {
        return entity.getPhoto();
    }

    @Override
    public CenterPhoto DtoToEntity(String dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> entitiesToDTOs(List<CenterPhoto> entities) {
        List<String> photos = new ArrayList<>();

        for (CenterPhoto centerPhoto : entities) {
            String photo = centerPhoto.getPhoto();
            photos.add(photo);
        }
        return photos;
    }

    @Override
    public List<CenterPhoto> DtosToEntities(List<String> dtos) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
