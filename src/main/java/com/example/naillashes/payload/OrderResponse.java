package com.example.naillashes.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class OrderResponse {

    private Long id;

    private UserSummary createdBy;

    private Instant creationDateTime;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long selectedStylist;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long selectedService;

}
