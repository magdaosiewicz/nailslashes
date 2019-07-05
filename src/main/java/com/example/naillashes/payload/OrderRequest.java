package com.example.naillashes.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class OrderRequest {

    private Date date;
//    private Long userId;
    private Long serviceId;
    private Long stylistId;





}
