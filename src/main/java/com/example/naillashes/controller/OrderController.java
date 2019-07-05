package com.example.naillashes.controller;


import com.example.naillashes.entity.Order;
import com.example.naillashes.payload.ApiResponse;
import com.example.naillashes.payload.OrderRequest;
import com.example.naillashes.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController("/api/auth")
public class OrderController {


    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    @PostMapping("/order")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest orderRequest){
        Order order = orderService.createVisit(orderRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{orderId}")
                .buildAndExpand(order.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true,"Order created successfully"));
    }


}
//    @PostMapping
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<?> createPoll(@Valid @RequestBody PollRequest pollRequest) {
//        Poll poll = pollService.createPoll(pollRequest);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{pollId}")
//                .buildAndExpand(poll.getId()).toUri();
//
//        return ResponseEntity.created(location)
//                .body(new ApiResponse(true, "Poll Created Successfully"));
//    }