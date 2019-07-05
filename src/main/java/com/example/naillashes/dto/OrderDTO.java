package com.example.naillashes.dto;

import com.example.naillashes.entity.Order;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private Long id;
    private Date date;
    private UserDTO user;
    private StylistDTO stylist;
    private ServiceDTO service;

    public static OrderDTO ofVisit(Order order){
        return OrderDTO.builder()
                .id(order.getId())
                .date(order.getDate())
//                .user(UserDTO.ofUser(order.getUser()))
                .stylist(StylistDTO.ofStylist(order.getStylist()))
                .service(ServiceDTO.ofService(order.getService()))
                .build();

    }


}
