package com.capstone.Ae_bank.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depositId;
    private int accountNum;
    private String bankName;
    private String currency;
    private String country;
    private String city;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer user;
    public Deposit() {
    }

    public Deposit(int accountNum, String bankName, String currency, String country, String city) {
        this.accountNum = accountNum;
        this.bankName = bankName;
        this.currency = currency;
        this.country = country;
        this.city = city;
    }


}
