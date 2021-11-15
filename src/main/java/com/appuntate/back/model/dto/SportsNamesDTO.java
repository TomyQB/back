package com.appuntate.back.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class SportsNamesDTO {

    private String name;
    private String image;
    
    public SportsNamesDTO() { }
    
    public SportsNamesDTO(String name, String image) {
        this.name = name;
        this.image = image;
    }

}
