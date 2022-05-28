package com.appuntate.back.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.annotation.PostConstruct;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudinaryService {
   
    @Autowired
    private EventPhotoService eventPhotoService;
    
    Cloudinary cloudinary;

    private Map<String, String> valuesMap = new HashMap<>();

    @PostConstruct
    public void initCloudinary() {
        valuesMap.put("cloud_name", "dxxvcl5fe");
        valuesMap.put("api_key", "686258587687993");
        valuesMap.put("api_secret", "x3pUHMTRDKK9ZX9jR4vUiMXvAp4");
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

    public void deleteImageByEventId(String publicKey) throws IOException {
        eventPhotoService.deleteEventPhotoByKey(publicKey);
    }
    
    public Map delete(String publicKey) throws IOException {
        Map result = cloudinary.uploader().destroy((publicKey), ObjectUtils.emptyMap());
        deleteImageByEventId(publicKey);
        return result;
    }
}
