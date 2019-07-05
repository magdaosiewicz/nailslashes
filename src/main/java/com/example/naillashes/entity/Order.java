package com.example.naillashes.entity;


import com.example.naillashes.entity.audit.UserDateAudit;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class Order extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "DATE")
    private Date date;

//    @ManyToOne(cascade = CascadeType.PERSIST)              // chyba to by trze abylo zmieni cna tak jak oni zrobili
//    @JoinColumn(name = "USER_ID")
//    private User user;

    @OneToOne(cascade = CascadeType.PERSIST)        // ok zrobi si eliste choices tak jak tmaci
    @JoinColumn(name = "STYLIST_ID")
    private Stylist stylist;

    @OneToOne(cascade = CascadeType.PERSIST)             // tez mozna zrobic choices
    @JoinColumn(name = "SERVICE_ID")
    private Service service;


}
