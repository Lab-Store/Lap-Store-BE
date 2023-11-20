package com.project.LapStore.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Sale {

    @Id @GeneratedValue
    @Column(name = "sale_id")
    private Long id;
}
