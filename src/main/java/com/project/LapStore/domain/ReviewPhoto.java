package com.project.LapStore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Getter @Setter
public class ReviewPhoto {

//    @Id
//    @GeneratedValue
//    @Column(name = "review_photo_id")
    private Long id;

    private String link;

//    @ManyToOne
//    @JoinColumn(name = "review_id")
    private Review review;


}
