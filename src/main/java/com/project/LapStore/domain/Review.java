package com.project.LapStore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter @Setter
public class Review {

//    @Id
//    @GeneratedValue
//    @Column(name = "review_id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "sale_id")
    private Sale sale;

//    private Item item;

//    @OneToMany(mappedBy = "review")
    private List<ReviewPhoto> reviewPhotoList = new ArrayList<>();


}
