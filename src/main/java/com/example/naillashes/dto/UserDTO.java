package com.example.naillashes.dto;


import com.example.naillashes.entity.User;
import com.example.naillashes.entity.Order;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Long phoneNumber;
    private List<Order> orders = new ArrayList<Order>();

    public static UserDTO ofUser(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .orders(user.getOrders())
                .build();
    }


}
