package com.example.naillashes.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SERVICES")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Service {

    @Id
    @Column(name = "SERVICE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SERVICE_NAME")
    @NotNull
    private String serviceName;

    @Column(name = "PRICE")
    @NotNull
    private Double price;

    @Column(name = "EXECUTION_TIME")
    @NotNull
    private int executionTime;






}
