package com.project.LapStore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Getter @Setter
public class Member {

//    @Id @GeneratedValue
//    @Column(name = "member_id")
    private Long id;

    private String userid;
    private String pwd;
    private String name;
    private String email;
    private String phone;

    private LocalDateTime dateJoined;
    private boolean isAdministrator;

//    @JsonIgnore
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<MemberItem> wishList = new ArrayList<>();

    public Member(Long id, String userid, String pwd, String name, String email, String phone, LocalDateTime dateJoined, boolean isAdministrator) {
        this.id = id;
        this.userid = userid;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dateJoined = dateJoined;
        this.isAdministrator = isAdministrator;
    }

    public Member(Member member) {
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateJoined=" + dateJoined +
                ", isAdministrator=" + isAdministrator +
                '}';
    }
}
