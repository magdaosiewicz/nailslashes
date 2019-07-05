package com.example.naillashes.controller;

import com.example.naillashes.dto.StylistDTO;
import com.example.naillashes.entity.Stylist;
import com.example.naillashes.service.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/stylist")
public class StylistController {


    @Autowired
    private StylistService stylistService;

    @PostMapping(value = "/addStylist")
    public ResponseEntity<StylistDTO> createStylist (StylistDTO stylistDTO) throws URISyntaxException {

        Stylist stylistToPersist =  Stylist.builder()
                .name(stylistDTO.getName())
                .surname(stylistDTO.getSurname())
                .review(stylistDTO.getReview())
                .photos(stylistDTO.getPhotos())
                .build();

        Stylist persistedStylist = stylistService.addStylist(stylistToPersist);
        return ResponseEntity.created(new URI("/api/stylist/" + persistedStylist.getId()))
                .body(StylistDTO.ofStylist(persistedStylist));
    }



}
