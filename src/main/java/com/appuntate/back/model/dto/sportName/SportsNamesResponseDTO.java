package com.appuntate.back.model.dto.sportName;


import lombok.Data;

@Data
public class SportsNamesResponseDTO {

    private String name;
    private String photo;
    
    public SportsNamesResponseDTO() { }
    
    public SportsNamesResponseDTO(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

}
