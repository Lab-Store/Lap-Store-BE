package com.project.LapStore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    private String name;
    private String brand;
    private int wishCount;
    private LocalDateTime registerDate;

    @OneToMany(mappedBy = "item")
    private List<MemberItem> memberItemList = new ArrayList<>();

//    private HashMap<String, String> specList;
//    private List<String> tagList;
//    private List<Sale> salelist;
}
