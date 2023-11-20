package com.project.LapStore.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class MemberItem {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private LocalDateTime dateRegistered;
}
