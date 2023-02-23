package com.capstone.Ae_bank.model;


import jakarta.persistence.*;

@Entity

public class WithDraw {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String receiverName;
    private int NIONum;
    private int receiverPhoneNum;
    private Long amount;
    private String createdDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer user;
    public WithDraw() {
    }

    public WithDraw(String receiverName, int NIONum, int receiverPhoneNum, Long amount, String createdDate) {
        this.receiverName = receiverName;
        this.NIONum = NIONum;
        this.receiverPhoneNum = receiverPhoneNum;
        this.amount = amount;
        this.createdDate = createdDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public int getNIONum() {
        return NIONum;
    }

    public void setNIONum(int NIONum) {
        this.NIONum = NIONum;
    }

    public int getReceiverPhoneNum() {
        return receiverPhoneNum;
    }

    public void setReceiverPhoneNum(int receiverPhoneNum) {
        this.receiverPhoneNum = receiverPhoneNum;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Customer getCustomer() {
        return user;
    }

    public void setCustomer(Customer user) {
        this.user = user;
    }
}
