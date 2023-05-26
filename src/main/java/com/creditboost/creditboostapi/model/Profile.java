package com.creditboost.creditboostapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profile {
    private Long idProfile;
    private String first_name;
    private String last_name;
    private Date date_of_birth;
    private String phone;
    private String ssn;
    private String ssn_last_four_digits;
    private long bank_account;
    private int bank_routing;
    private String bank_name;
    private int curr_credit_score;
    private int total_num_open_loan;
}
