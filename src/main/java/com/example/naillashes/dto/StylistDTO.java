package com.example.naillashes.dto;

import com.example.naillashes.entity.Photo;
import com.example.naillashes.entity.Stylist;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StylistDTO {

    private Long id;
    private String name;
    private String surname;
    private Integer review;
    private List<Photo> photos= new ArrayList<>();

    public static StylistDTO ofStylist(Stylist stylist){
        return StylistDTO.builder()
                .id(stylist.getId())
                .name(stylist.getName())
                .surname(stylist.getSurname())
                .review(stylist.getReview())
                .photos(stylist.getPhotos())
                .build();

    }

}
