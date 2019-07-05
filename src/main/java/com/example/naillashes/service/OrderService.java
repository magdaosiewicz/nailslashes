package com.example.naillashes.service;

import com.example.naillashes.entity.Order;
import com.example.naillashes.payload.OrderRequest;
import com.example.naillashes.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private StylistService stylistService;

    @Autowired
    private ServiceService serviceService;

//    public Poll createPoll(PollRequest pollRequest) {
//        Poll poll = new Poll();
//        poll.setQuestion(pollRequest.getQuestion());
//
//        pollRequest.getChoices().forEach(choiceRequest -> {
//            poll.addChoice(new Choice(choiceRequest.getText()));
//        });
//
//        Instant now = Instant.now();
//        Instant expirationDateTime = now.plus(Duration.ofDays(pollRequest.getPollLength().getDays()))
//                .plus(Duration.ofHours(pollRequest.getPollLength().getHours()));
//
//        poll.setExpirationDateTime(expirationDateTime);
//
//        return pollRepository.save(poll);
//    }

    public Order createVisit (OrderRequest orderRequest){
        Order order = Order.builder()
                .date(orderRequest.getDate())
//                .user(userService.getUserById(orderRequest.getUserId()))
                .service(serviceService.getServiceById(orderRequest.getServiceId()))
                .stylist(stylistService.getStylistById(orderRequest.getStylistId()))
                .build();

        return visitRepository.save(order);
    }
}














