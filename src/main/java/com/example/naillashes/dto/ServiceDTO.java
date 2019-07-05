package com.example.naillashes.dto;

import com.example.naillashes.entity.Service;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDTO {

    private Long id;
    private String serviceName;
    private Double price;
    private int executionTime;

   public static ServiceDTO ofService(Service service){
       return ServiceDTO.builder()
               .id(service.getId())
               .serviceName(service.getServiceName())
               .price(service.getPrice())
               .executionTime(service.getExecutionTime())
               .build();
   }
}
