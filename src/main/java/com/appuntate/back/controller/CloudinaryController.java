package com.appuntate.back.controller;

import java.io.IOException;
import java.util.Map;

import com.appuntate.back.model.dto.cloudinary.CloudinaryDTO;
import com.appuntate.back.service.CloudinaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class CloudinaryController {
    
    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping("/uploadCloudinary")
    public CloudinaryDTO upload(@RequestParam MultipartFile multipartFile) throws IOException {
        Map result = cloudinaryService.upload(multipartFile);
        CloudinaryDTO cloudinaryDTO = new CloudinaryDTO();
        cloudinaryDTO.setImageId((String) result.get("public_id"));
        cloudinaryDTO.setUrl((String) result.get("url"));
        return cloudinaryDTO;
    }  
    
    @PostMapping("/deleteCloudinary")
    public Map delete(@RequestParam String publicKey) throws IOException {
        return cloudinaryService.delete(publicKey);
    }
}
