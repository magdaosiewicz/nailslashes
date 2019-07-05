package com.example.naillashes.service;

import com.example.naillashes.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public com.example.naillashes.entity.Service getServiceById(Long serviceId){
        return serviceRepository.getOne(serviceId);
    }

    public List<com.example.naillashes.entity.Service> getAllServices(){
       return serviceRepository.findAll();
    }


}
