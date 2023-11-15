package com.project.LapStore.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
@Getter @Setter
public class Sale {

//    @Id @GeneratedValue
//    @Column(name = "sale_id")
    private Long id;
}
