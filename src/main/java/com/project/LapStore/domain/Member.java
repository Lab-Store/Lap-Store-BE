package com.project.LapStore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String userid;
    private String pwd;
    private String name;
    private String email;
    private String phone;

    private LocalDateTime dateJoined;
    private boolean isAdministrator;

//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<MemberItem> wishList = new ArrayList<>();

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
