package com.creditboost.creditboostapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(name="username", length = 255)
    private String username;
    @Column(name="password", length = 255)
    private String password;
    @Column(name="email", length = 255)
    private String email;
//    private int idprofile;
//    private int accountstatus;


    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
