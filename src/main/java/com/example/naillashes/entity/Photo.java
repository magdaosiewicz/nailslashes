package com.example.naillashes.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "PHOTOS")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Photo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "type")
    private String fileName;

    private String fileType;

    @Column(name = "REVIEW")
    private int review;

    @Lob
    @Column(name = "pic")
    private byte[] data;

    public Photo(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        //this.review=review;
        this.data = data;

    }
}