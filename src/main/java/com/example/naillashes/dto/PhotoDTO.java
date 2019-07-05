package com.example.naillashes.dto;
import com.example.naillashes.entity.Photo;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoDTO {

    private String id;
    private int review;

    public static PhotoDTO ofPhoto(Photo photo){
        return PhotoDTO.builder()
                .id(photo.getId())
                .review(photo.getReview())
                .build();
    }

//    public static Lst ofPhotos(Photo photo){
//        return PhotoDTO.builder()
//                .id(photo.getId())
//                .review(photo.getReview())
//                .build();
//    }

}
