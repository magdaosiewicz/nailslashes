package com.example.naillashes.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "STYLISTS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Stylist {

    @Id
    @Column(name = "STYLIST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;
    @NotNull
    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "REVIEW")
    private Integer review;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PHOTOS_OF_STYLIST",
            joinColumns = @JoinColumn(name = "STYLIST_ID"),
            inverseJoinColumns = @JoinColumn(name = "PHOTO_ID"))
    private List<Photo> photos= new ArrayList<>();


}
