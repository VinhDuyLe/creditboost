package com.creditboost.creditboostapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private Long idUser;
    private String username;
    private String password;
    private String email;
}
