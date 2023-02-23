package com.capstone.Ae_bank.model;


import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int accountNum;
    private String transactionType;
    private int routingNum;
    private String transactionDate;
    private String transactionDescription;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer user;
    public Transaction() {
    }

    public Transaction(int accountNum, String transactionType, int routingNum, String transactionDate, String transactionDescription) {
        this.accountNum = accountNum;
        this.transactionType = transactionType;
        this.routingNum = routingNum;
        this.transactionDate = transactionDate;
        this.transactionDescription = transactionDescription;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getRoutingNum() {
        return routingNum;
    }

    public void setRoutingNum(int routingNum) {
        this.routingNum = routingNum;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Customer getCustomer() {
        return user;
    }

    public void setCustomer(Customer user) {
        this.user = user;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }
}
