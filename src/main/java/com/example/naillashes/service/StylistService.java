package com.example.naillashes.service;

import com.example.naillashes.entity.Stylist;
import com.example.naillashes.repository.StylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StylistService {


    @Autowired
    private StylistRepository stylistRepository;

    public Stylist addStylist(Stylist stylist){
        return stylistRepository.save(stylist);
    }

    public Stylist getStylistById(Long stylistId){
        return stylistRepository.getOne(stylistId);
    }



}
