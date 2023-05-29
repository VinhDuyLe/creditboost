package com.creditboost.creditboostapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfile;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String phone;
    private String ssn;
    private String ssn_last_four_digits;
    private long bank_account;
    private int bank_routing;
    private String bank_name;
    private int curr_credit_score;
    private int total_num_open_loan;

    public ProfileEntity(String first_name, String last_name, String date_of_birth, String phone, String ssn, String ssn_last_four_digits, long bank_account, int bank_routing, String bank_name, int curr_credit_score, int total_num_open_loan) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.phone = phone;
        this.ssn = ssn;
        this.ssn_last_four_digits = ssn_last_four_digits;
        this.bank_account = bank_account;
        this.bank_routing = bank_routing;
        this.bank_name = bank_name;
        this.curr_credit_score = curr_credit_score;
        this.total_num_open_loan = total_num_open_loan;
    }
}
