package com.capstone.Ae_bank.model;

import com.capstone.Ae_bank.enums.AccountStatus;
import com.capstone.Ae_bank.enums.OperationType;
import jakarta.persistence.*;


@MappedSuperclass
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int accountNumber;
    private String description;

    @Enumerated(EnumType.STRING)
    private OperationType type;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    protected double balance;

    private String postDate;

    public Account() {
    }

    public Account(Long id, int accountNumber, String description, OperationType type, AccountStatus status, double balance, String postDate) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.description = description;
        this.type = type;
        this.status = status;
        this.balance = balance;

        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public abstract void deposit(double account);
    public abstract void withdraw(double account);
}
